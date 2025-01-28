package com.wayoukiss.android.data.repositories

import com.wayoukiss.android.core.security.TokenManager
import com.wayoukiss.android.data.api.AuthApi
import com.wayoukiss.android.data.api.GoogleSignInRequest
import com.wayoukiss.android.data.api.RefreshTokenRequest
import com.wayoukiss.android.domain.models.AuthResult
import com.wayoukiss.android.domain.repositories.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi,
    private val tokenManager: TokenManager
) : AuthRepository {

    override suspend fun signInWithGoogle(idToken: String): AuthResult {
        return try {
            val response = api.signInWithGoogle(GoogleSignInRequest(idToken))
            tokenManager.saveToken(response.accessToken)
            tokenManager.saveRefreshToken(response.refreshToken)
            AuthResult.Success(
                accessToken = response.accessToken,
                refreshToken = response.refreshToken
            )
        } catch (e: IOException) {
            AuthResult.Error.Network(e.message ?: "Network error occurred")
        } catch (e: HttpException) {
            when (e.code()) {
                401 -> AuthResult.Error.InvalidCredentials("Invalid Google token")
                else -> AuthResult.Error.Server(e.code(), e.message())
            }
        } catch (e: Exception) {
            AuthResult.Error.Server(500, e.message ?: "Unknown error occurred")
        }
    }

    override suspend fun signOut() {
        tokenManager.deleteToken()
        tokenManager.deleteRefreshToken()
    }

    override fun observeAuthState(): Flow<Boolean> {
        return tokenManager.getToken().map { it != null }
    }

    override fun getAccessToken(): String? {
        return tokenManager.getTokenBlocking()
    }

    override suspend fun refreshToken(): Boolean {
        return try {
            val currentRefreshToken = tokenManager.getRefreshToken().first()
            if (currentRefreshToken == null) {
                false
            } else {
                val response = api.refreshToken(RefreshTokenRequest(currentRefreshToken))
                tokenManager.saveToken(response.accessToken)
                tokenManager.saveRefreshToken(response.refreshToken)
                true
            }
        } catch (e: Exception) {
            false
        }
    }
}
