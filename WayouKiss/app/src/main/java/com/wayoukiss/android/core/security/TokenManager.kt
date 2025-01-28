package com.wayoukiss.android.core.security

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

@Singleton
class TokenManager @Inject constructor(
    @ApplicationContext context: Context
) {
    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val sharedPreferences = EncryptedSharedPreferences.create(
        context,
        "secure_prefs",
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    suspend fun saveToken(accessToken: String) {
        withContext(Dispatchers.IO) {
            sharedPreferences.edit()
                .putString(KEY_ACCESS_TOKEN, accessToken)
                .apply()
        }
    }

    suspend fun saveRefreshToken(refreshToken: String) {
        withContext(Dispatchers.IO) {
            sharedPreferences.edit()
                .putString(KEY_REFRESH_TOKEN, refreshToken)
                .apply()
        }
    }

    suspend fun saveTokens(accessToken: String, refreshToken: String) {
        withContext(Dispatchers.IO) {
            sharedPreferences.edit()
                .putString(KEY_ACCESS_TOKEN, accessToken)
                .putString(KEY_REFRESH_TOKEN, refreshToken)
                .apply()
        }
    }

    fun getToken(): Flow<String?> = flow {
        emit(sharedPreferences.getString(KEY_ACCESS_TOKEN, null))
    }

    fun getTokenBlocking(): String? {
        return sharedPreferences.getString(KEY_ACCESS_TOKEN, null)
    }

    suspend fun getAccessToken(): String? = withContext(Dispatchers.IO) {
        sharedPreferences.getString(KEY_ACCESS_TOKEN, null)
    }

    suspend fun getRefreshToken(): String? = withContext(Dispatchers.IO) {
        sharedPreferences.getString(KEY_REFRESH_TOKEN, null)
    }

    suspend fun deleteToken() {
        withContext(Dispatchers.IO) {
            sharedPreferences.edit()
                .remove(KEY_ACCESS_TOKEN)
                .apply()
        }
    }

    suspend fun deleteRefreshToken() {
        withContext(Dispatchers.IO) {
            sharedPreferences.edit()
                .remove(KEY_REFRESH_TOKEN)
                .apply()
        }
    }

    suspend fun clearTokens() {
        withContext(Dispatchers.IO) {
            sharedPreferences.edit().clear().apply()
        }
    }

    companion object {
        private const val KEY_ACCESS_TOKEN = "access_token"
        private const val KEY_REFRESH_TOKEN = "refresh_token"
    }
}
