package com.example.myapplication.screens.profile

import androidx.compose.runtime.Composable

import androidx.compose.material3.Text

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Column

import androidx.compose.ui.Modifier

import com.example.myapplication.components.ProfileHeader.ProfileHeader

@Composable
fun ProfileScreen(
    modifier : Modifier
){
    Column(
        modifier = Modifier.fillMaxSize()
    ){
    ProfileHeader(
        modifier = Modifier.weight(1/3f)
    )
    }
}