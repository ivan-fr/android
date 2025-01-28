package com.wayoukiss.android.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wayoukiss.android.domain.models.AuthResult
import com.wayoukiss.android.domain.usecases.SignInWithGoogleUseCase
import com.wayoukiss.android.domain.usecases.SignOutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val signInWithGoogleUseCase: SignInWithGoogleUseCase,
    private val signOutUseCase: SignOutUseCase
) : ViewModel() {

    private val _authState = MutableStateFlow<AuthUiState>(AuthUiState.Initial)
    val authState: StateFlow<AuthUiState> = _authState

    fun signInWithGoogle(idToken: String) {
        viewModelScope.launch {
            _authState.value = AuthUiState.Loading
            val result = signInWithGoogleUseCase(idToken)
            _authState.value = when (result) {
                is AuthResult.Success -> AuthUiState.Success
                is AuthResult.Error.Network -> AuthUiState.Error("Network error: ${result.message}")
                is AuthResult.Error.Server -> AuthUiState.Error("Server error: ${result.message}")
                is AuthResult.Error.InvalidCredentials -> AuthUiState.Error(result.message)
                AuthResult.Error.TokenExpired -> AuthUiState.Error("Session expired. Please sign in again.")
            }
        }
    }

    fun signOut() {
        viewModelScope.launch {
            signOutUseCase()
            _authState.value = AuthUiState.Initial
        }
    }
}

sealed class AuthUiState {
    data object Initial : AuthUiState()
    data object Loading : AuthUiState()
    data object Success : AuthUiState()
    data class Error(val message: String) : AuthUiState()
}
