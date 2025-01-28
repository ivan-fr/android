package com.wayoukiss.android.domain.usecases

import com.wayoukiss.android.domain.repositories.AuthRepository
import javax.inject.Inject

class SignOutUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke() {
        authRepository.signOut()
    }
}
