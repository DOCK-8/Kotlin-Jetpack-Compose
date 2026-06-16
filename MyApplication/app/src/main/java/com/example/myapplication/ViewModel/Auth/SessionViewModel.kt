package com.example.myapplication.ViewModel.Auth

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.myapplication.di.Singletons
import com.example.myapplication.models.repository.Auth.UserSessionRepository

class SessionViewModel(
    private val userSessionRepository: UserSessionRepository = Singletons.Repositories.userSessionRepository
) : ViewModel() {
    private val _logged = MutableStateFlow(false)
    val logged = _logged.asStateFlow()

    fun login() {
        _logged.value = true
        userSessionRepository.userLogged()
    }

    fun logout() {
        _logged.value = false
        userSessionRepository.userLogout()
    }
}