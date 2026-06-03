package com.example.myapplication.models.repository.Auth

import com.example.myapplication.models.DB
import com.example.myapplication.models.data.User

object RegisterRepository{
    fun addUserDB(name : String, email : String, password : String){
        val newUser = User(
            name = name,
            password = password,
            email = email
        )
        DB.listUsuarios.add(newUser)
    }
}