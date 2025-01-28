package com.wayoukiss.android.presentation.auth

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FakeAuthViewModel(initialState: AuthUiState) : ViewModel() {
    private val _authState = MutableStateFlow(initialState)
    val authState: StateFlow<AuthUiState> = _authState

    fun signInWithGoogle(idToken: String) {
        // Simulate sign-in process
        _authState.value = AuthUiState.Loading
        // In real tests, we might want to add delay here
        _authState.value = when {
            idToken.startsWith("valid_") -> AuthUiState.Success
            idToken.startsWith("network_error_") -> AuthUiState.Error("Network error occurred")
            else -> AuthUiState.Error("Invalid credentials")
        }
    }

    fun signOut() {
        _authState.value = AuthUiState.Initial
    }
}
