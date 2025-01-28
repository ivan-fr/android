package com.wayoukiss.android.domain.usecases

import com.wayoukiss.android.domain.models.AuthResult
import com.wayoukiss.android.domain.repositories.AuthRepository
import javax.inject.Inject

class SignInWithGoogleUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(idToken: String): AuthResult {
        return authRepository.signInWithGoogle(idToken)
    }
}
