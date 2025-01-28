package com.wayoukiss.android.data.repositories

import com.wayoukiss.android.core.security.TokenManager
import com.wayoukiss.android.data.api.AuthApi
import com.wayoukiss.android.data.api.AuthResponse
import com.wayoukiss.android.data.api.GoogleSignInRequest
import com.wayoukiss.android.domain.models.AuthResult
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class AuthRepositoryImplTest {
    private lateinit var repository: AuthRepositoryImpl
    private lateinit var api: AuthApi
    private lateinit var tokenManager: TokenManager

    @Before
    fun setup() {
        api = mockk()
        tokenManager = mockk(relaxed = true)
        repository = AuthRepositoryImpl(api, tokenManager)
    }

    @Test
    fun `signInWithGoogle with valid token returns success`() = runTest {
        // Given
        val idToken = "valid_token"
        val authResponse = AuthResponse(
            accessToken = "access_token",
            refreshToken = "refresh_token",
            expiresIn = 3600L
        )
        coEvery { api.signInWithGoogle(GoogleSignInRequest(idToken)) } returns authResponse

        // When
        val result = repository.signInWithGoogle(idToken)

        // Then
        assertTrue(result is AuthResult.Success)
        result as AuthResult.Success
        assertEquals("access_token", result.accessToken)
        assertEquals("refresh_token", result.refreshToken)
        coVerify {
            tokenManager.saveToken("access_token")
            tokenManager.saveRefreshToken("refresh_token")
        }
    }

    @Test
    fun `signInWithGoogle with network error returns NetworkError`() = runTest {
        // Given
        val idToken = "valid_token"
        coEvery { api.signInWithGoogle(any()) } throws IOException("No internet connection")

        // When
        val result = repository.signInWithGoogle(idToken)

        // Then
        assertTrue(result is AuthResult.Error.Network)
        result as AuthResult.Error.Network
        assertEquals("No internet connection", result.message)
    }

    @Test
    fun `signInWithGoogle with invalid credentials returns InvalidCredentials`() = runTest {
        // Given
        val idToken = "invalid_token"
        val errorResponse = Response.error<AuthResponse>(
            401,
            "Unauthorized".toResponseBody(null)
        )
        coEvery { api.signInWithGoogle(any()) } throws HttpException(errorResponse)

        // When
        val result = repository.signInWithGoogle(idToken)

        // Then
        assertTrue(result is AuthResult.Error.InvalidCredentials)
    }

    @Test
    fun `signOut clears tokens`() = runTest {
        // When
        repository.signOut()

        // Then
        coVerify {
            tokenManager.deleteToken()
            tokenManager.deleteRefreshToken()
        }
    }

    @Test
    fun `observeAuthState emits true when token exists`() = runTest {
        // Given
        coEvery { tokenManager.getToken() } returns flowOf("valid_token")

        // When
        val isAuthenticated = repository.observeAuthState().first()

        // Then
        assertTrue(isAuthenticated)
    }

    @Test
    fun `observeAuthState emits false when token is null`() = runTest {
        // Given
        coEvery { tokenManager.getToken() } returns flowOf(null)

        // When
        val isAuthenticated = repository.observeAuthState().first()

        // Then
        assertFalse(isAuthenticated)
    }
}
