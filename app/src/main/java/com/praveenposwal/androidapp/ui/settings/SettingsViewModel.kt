package com.praveenposwal.androidapp.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.praveenposwal.androidapp.domain.usecase.LogoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val logoutUseCase: LogoutUseCase
) : ViewModel() {

    fun logout() {
        viewModelScope.launch {
            logoutUseCase()
        }
    }
}
