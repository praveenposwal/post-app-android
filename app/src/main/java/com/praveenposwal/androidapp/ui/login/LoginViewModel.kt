package com.praveenposwal.androidapp.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.praveenposwal.androidapp.domain.usecase.CheckLoginStatusUseCase
import com.praveenposwal.androidapp.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    checkLoginStatusUseCase: CheckLoginStatusUseCase
) : ViewModel() {

    val isLoggedIn = checkLoginStatusUseCase()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), false)

    fun login() {
        viewModelScope.launch {
            loginUseCase()
        }
    }
}
