package com.example.myapplication.components.SearchBar

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.foundation.text.input.rememberTextFieldState

@Composable
fun SearchBar(){
    Row{
        TextField(
            state = rememberTextFieldState(),
            modifier = Modifier
            .fillMaxWidth(),
            placeholder = {
                Text(
                    text = "Buscar"
                )
            }
        )
    }
}