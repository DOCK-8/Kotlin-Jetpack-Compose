package com.example.myapplication.ViewModel.Auth

import com.example.myapplication.di.Singletons
import com.example.myapplication.models.repository.Auth.SessionRepository
import com.example.myapplication.models.data.User
// VM
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
// End

class LoginViewModel(
    private val sessionRepository: SessionRepository = Singletons.Repositories.sessionRepository
) : ViewModel(){
    private val _name = MutableStateFlow("")
    private val _password = MutableStateFlow("")
    private val _message = MutableStateFlow("")
    val name = _name.asStateFlow()
    val password = _password.asStateFlow()
    val message = _message.asStateFlow()

    fun onValueName(name : String){
        _name.value = name
    }
    fun onValuePassword(password : String){
        _password.value = password
    }

    fun loginUser() : Boolean{
       val status = sessionRepository.userDataVerificate(name = name.value, password = password.value)
        if (status)
            _message.value = "Session Succesly"
        else
            _message.value = "Session Error"
        return status
    }
}