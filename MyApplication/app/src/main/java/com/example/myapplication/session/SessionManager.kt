package com.example.myapplication.session

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.myapplication.models.repository.Auth.UserSessionRepository

object SessionManager {
    private val _logged = MutableStateFlow(false)
    val logged = _logged.asStateFlow()

    fun login() {
        _logged.value = true
        UserSessionRepository.userLogged()
    }

    fun logout() {
        _logged.value = false
        UserSessionRepository.userLogout()
    }
}
