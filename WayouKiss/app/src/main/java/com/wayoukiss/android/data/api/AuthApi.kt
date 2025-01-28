package com.wayoukiss.android.data.api

import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/google")
    suspend fun signInWithGoogle(
        @Body request: GoogleSignInRequest
    ): AuthResponse

    @POST("auth/refresh")
    suspend fun refreshToken(
        @Body request: RefreshTokenRequest
    ): AuthResponse
}

data class GoogleSignInRequest(
    val idToken: String
)

data class RefreshTokenRequest(
    val refreshToken: String
)

data class AuthResponse(
    val accessToken: String,
    val refreshToken: String,
    val expiresIn: Long
)
