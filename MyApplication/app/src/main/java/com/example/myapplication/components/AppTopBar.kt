package com.example.myapplication.components

import androidx.compose.runtime.Composable
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(nameView : String){
    TopAppBar( title = {
        Text(nameView)
    })
}