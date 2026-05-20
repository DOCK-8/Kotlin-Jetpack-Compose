package com.example.myapplication.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width


@Composable
fun ProductCard(
    nombre : String,
    precio : Double
){
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ){
        Column(){
            Text(text = nombre, fontSize = 20.sp)
            Text(text = "S/. $precio")
            Spacer( modifier = Modifier.width(8.dp))
            Button(onClick = {}){
                Text("Agregar")
            }
        }
    }
}