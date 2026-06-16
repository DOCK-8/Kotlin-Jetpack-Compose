package com.example.myapplication.ViewModel.Auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.di.Singletons
import com.example.myapplication.models.repository.Auth.UserSessionRepository

class SessionViewModelFactory(
    private val userSessionRepository: UserSessionRepository = Singletons.Repositories.userSessionRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SessionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SessionViewModel(userSessionRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}
