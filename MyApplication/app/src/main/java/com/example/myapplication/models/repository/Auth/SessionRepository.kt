package com.example.myapplication.models.repository.Auth

// Data Class
import com.example.myapplication.models.data.User

object SessionRepository{
    private var userSession : User? = null

    fun getUserName() : String{
        return userSession?.name?:""
    }
    fun getUserPassword() : String{
        return userSession?.password?:""
    }
    fun getUserInfoDB(namUser : String){
        //Implementacion call Base de Datos
        //Null
        // return Unit
        //Be
        userSession = User(
            name = "JulioProfe",
            password = "Alan",
            email = "example@gmail.com"
        )
    }
    fun userDataVerificate(name : String, password : String) : Boolean{
        getUserInfoDB(name)
        if(SessionRepository.getUserName() == name)
            if(SessionRepository.getUserPassword() == password)  
                return true
        return false
    }
}