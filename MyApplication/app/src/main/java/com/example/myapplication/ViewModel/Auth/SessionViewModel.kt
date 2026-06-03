package com.example.myapplication.ViewModel.Auth

//import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object SessionViewModel {
    private val _logged = MutableStateFlow(false)

    val logged = _logged.asStateFlow()

    fun login() {
        _logged.value = true
    }

    fun logout() {
        _logged.value = false
    }
}