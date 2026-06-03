package com.example.myapplication.ViewModel.Auth

import com.example.myapplication.models.repository.Auth.RegisterRepository
// VM
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
// End

class RegisterViewModel : ViewModel(){
    private val _name = MutableStateFlow<String>("")
    private val _email = MutableStateFlow<String>("")
    private val _password = MutableStateFlow<String>("")
    val name = _name.asStateFlow()
    val email = _email.asStateFlow()
    val password = _password.asStateFlow()

    fun onChangeName(name : String){
        _name.value =  name
    }
    fun onChangeEmail(email : String){
        _email.value = email
    }
    fun onChangePassword(password : String){
        _password.value = password
    }
    fun onRegisterUser(){
       RegisterRepository.addUserDB(name.value,email.value,password.value) 
    }
}