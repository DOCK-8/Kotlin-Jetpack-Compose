package com.example.myapplication.components.ProfileHeader

import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.Column

import androidx.compose.ui.Modifier

import com.example.myapplication.components.Avatar.Avatar

@Composable
fun ProfileHeader(
    modifier : Modifier
){

    Column(
        modifier = modifier
    ){
        Avatar()
    }
}