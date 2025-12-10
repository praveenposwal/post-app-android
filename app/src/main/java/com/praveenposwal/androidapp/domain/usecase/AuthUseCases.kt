package com.praveenposwal.androidapp.domain.usecase

import com.praveenposwal.androidapp.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke() = repository.login()
}

class LogoutUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke() = repository.logout()
}

class CheckLoginStatusUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke() = repository.isLoggedIn
}
