package com.example.myapplication.models.repository.User

import com.example.myapplication.models.DB
import com.example.myapplication.models.data.User

object ProfileRepository{
    fun getDataUser(name : String) : User{
        val userI = DB.listUsuarios.find{it.name == name}
        return userI?: User(name = "Loki", email = "ThorEldiosDeLosMartillos@gmail.com", password = "Love Me")
    }
}