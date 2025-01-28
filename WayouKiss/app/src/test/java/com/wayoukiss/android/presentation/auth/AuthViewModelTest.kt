package com.wayoukiss.android.presentation.auth

import app.cash.turbine.test
import com.wayoukiss.android.domain.models.AuthResult
import com.wayoukiss.android.domain.usecases.SignInWithGoogleUseCase
import com.wayoukiss.android.domain.usecases.SignOutUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class AuthViewModelTest {
    private lateinit var viewModel: AuthViewModel
    private lateinit var signInWithGoogleUseCase: SignInWithGoogleUseCase
    private lateinit var signOutUseCase: SignOutUseCase
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        signInWithGoogleUseCase = mockk()
        signOutUseCase = mockk(relaxed = true)
        viewModel = AuthViewModel(signInWithGoogleUseCase, signOutUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `signInWithGoogle emits loading then success states on successful sign in`() = runTest {
        // Given
        val idToken = "valid_token"
        coEvery { signInWithGoogleUseCase(idToken) } returns AuthResult.Success(
            accessToken = "access_token",
            refreshToken = "refresh_token"
        )

        // When & Then
        viewModel.authState.test {
            assertTrue(awaitItem() is AuthUiState.Initial)
            viewModel.signInWithGoogle(idToken)
            assertTrue(awaitItem() is AuthUiState.Loading)
            assertTrue(awaitItem() is AuthUiState.Success)
        }
    }

    @Test
    fun `signInWithGoogle emits loading then error states on network error`() = runTest {
        // Given
        val idToken = "valid_token"
        val errorMessage = "Network error occurred"
        coEvery { signInWithGoogleUseCase(idToken) } returns AuthResult.Error.Network(errorMessage)

        // When & Then
        viewModel.authState.test {
            assertTrue(awaitItem() is AuthUiState.Initial)
            viewModel.signInWithGoogle(idToken)
            assertTrue(awaitItem() is AuthUiState.Loading)
            val errorState = awaitItem() as AuthUiState.Error
            assertTrue(errorState.message.contains(errorMessage))
        }
    }

    @Test
    fun `signInWithGoogle emits loading then error states on invalid credentials`() = runTest {
        // Given
        val idToken = "invalid_token"
        val errorMessage = "Invalid credentials"
        coEvery { signInWithGoogleUseCase(idToken) } returns AuthResult.Error.InvalidCredentials(errorMessage)

        // When & Then
        viewModel.authState.test {
            assertTrue(awaitItem() is AuthUiState.Initial)
            viewModel.signInWithGoogle(idToken)
            assertTrue(awaitItem() is AuthUiState.Loading)
            val errorState = awaitItem() as AuthUiState.Error
            assertTrue(errorState.message == errorMessage)
        }
    }

    @Test
    fun `signOut resets state to initial`() = runTest {
        // When
        viewModel.signOut()

        // Then
        viewModel.authState.test {
            assertTrue(awaitItem() is AuthUiState.Initial)
        }
        coVerify { signOutUseCase() }
    }
}
