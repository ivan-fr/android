package com.wayoukiss.android.domain.models

sealed class AuthResult {
    data class Success(
        val accessToken: String,
        val refreshToken: String
    ) : AuthResult()

    sealed class Error : AuthResult() {
        data class Network(val message: String) : Error()
        data class Server(val code: Int, val message: String) : Error()
        data class InvalidCredentials(val message: String) : Error()
        data object TokenExpired : Error()
    }
}
