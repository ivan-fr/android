package com.wayoukiss.android.domain.repositories

import com.wayoukiss.android.domain.models.AuthResult
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun signInWithGoogle(idToken: String): AuthResult
    suspend fun signOut()
    fun observeAuthState(): Flow<Boolean>
    fun getAccessToken(): String?
    suspend fun refreshToken(): Boolean
}
