package com.example.myapplication.ViewModel.User

import com.example.myapplication.models.repository.User.ProfileRepository
import com.example.myapplication.models.data.User
// VM
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel:ViewModel(){
    private val _userData = MutableStateFlow<User?>(null)

    val userData = _userData.asStateFlow()

    fun getUserData(name : String){
        _userData.value = ProfileRepository.getDataUser(name)
    }
    fun getUserName() : String{
        return userData?.value?.name?:"Loki"
    }
    fun getUserEmail() : String{
        return userData?.value?.email?:"thor@gmail.com"
    }
}