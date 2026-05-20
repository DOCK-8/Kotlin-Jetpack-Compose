package com.example.myapplication.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.foundation.layout.fillMaxWidth

@Composable
fun SearchBar(
    value : String,
    onValueChange : (String) -> Unit,
    modifier : Modifier = Modifier
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = {
            Text("Buscar producto")
        }
    )
}