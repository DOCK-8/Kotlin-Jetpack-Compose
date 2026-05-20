package com.example.myapplication.components

import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth

@Composable
fun PrimaryButtons(
    text : String,
    onClick : () -> Unit,
    modifier : Modifier = Modifier
){
    Button(
        onClick = onClick,
        modifier = modifier
    ){
        Text(text = text)
    }
}