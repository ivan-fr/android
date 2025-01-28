package com.wayoukiss.android.auth

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.wayoukiss.android.MainActivity
import com.wayoukiss.android.core.security.TokenManager
import com.wayoukiss.android.data.api.AuthApi
import com.wayoukiss.android.data.repositories.AuthRepositoryImpl
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

@HiltAndroidTest
class AuthenticationFlowTest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Inject
    lateinit var tokenManager: TokenManager

    private lateinit var mockWebServer: MockWebServer
    private lateinit var authApi: AuthApi
    private lateinit var authRepository: AuthRepositoryImpl

    @Before
    fun setup() {
        hiltRule.inject()
        Intents.init()

        mockWebServer = MockWebServer()
        mockWebServer.start()

        // Setup Retrofit with MockWebServer
        val retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        authApi = retrofit.create(AuthApi::class.java)
        authRepository = AuthRepositoryImpl(authApi, tokenManager)
    }

    @After
    fun tearDown() {
        Intents.release()
        mockWebServer.shutdown()
    }

    @Test
    fun successfulGoogleSignInFlow() = runTest {
        // Given
        val successResponse = MockResponse()
            .setResponseCode(200)
            .setBody("""
                {
                    "accessToken": "test_access_token",
                    "refreshToken": "test_refresh_token",
                    "expiresIn": 3600
                }
            """.trimIndent())
        mockWebServer.enqueue(successResponse)

        // When
        val initialAuthState = authRepository.observeAuthState().first()
        assertFalse(initialAuthState)

        // Simulate successful Google Sign-In
        val idToken = "valid_test_token"
        val result = authRepository.signInWithGoogle(idToken)

        // Then
        assertTrue(result is com.wayoukiss.android.domain.models.AuthResult.Success)
        assertTrue(authRepository.observeAuthState().first())

        // Verify Google Sign-In Intent
        Intents.intended(IntentMatchers.hasAction(GoogleSignIn.ACTION_SIGN_IN))
    }

    @Test
    fun failedGoogleSignInFlow() = runTest {
        // Given
        val errorResponse = MockResponse()
            .setResponseCode(401)
            .setBody("""
                {
                    "error": "Invalid token"
                }
            """.trimIndent())
        mockWebServer.enqueue(errorResponse)

        // When
        val initialAuthState = authRepository.observeAuthState().first()
        assertFalse(initialAuthState)

        // Simulate failed Google Sign-In
        val idToken = "invalid_test_token"
        val result = authRepository.signInWithGoogle(idToken)

        // Then
        assertTrue(result is com.wayoukiss.android.domain.models.AuthResult.Error.InvalidCredentials)
        assertFalse(authRepository.observeAuthState().first())
    }

    @Test
    fun signOutFlow() = runTest {
        // Given
        tokenManager.saveToken("test_access_token")
        tokenManager.saveRefreshToken("test_refresh_token")
        assertTrue(authRepository.observeAuthState().first())

        // When
        authRepository.signOut()

        // Then
        assertFalse(authRepository.observeAuthState().first())
    }

    @Test
    fun tokenRefreshFlow() = runTest {
        // Given
        val refreshResponse = MockResponse()
            .setResponseCode(200)
            .setBody("""
                {
                    "accessToken": "new_access_token",
                    "refreshToken": "new_refresh_token",
                    "expiresIn": 3600
                }
            """.trimIndent())
        mockWebServer.enqueue(refreshResponse)

        tokenManager.saveRefreshToken("old_refresh_token")

        // When
        val refreshResult = authRepository.refreshToken()

        // Then
        assertTrue(refreshResult)
        assertTrue(tokenManager.getToken().first() == "new_access_token")
        assertTrue(tokenManager.getRefreshToken().first() == "new_refresh_token")
    }
}
