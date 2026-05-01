package com.example.myapplication.View

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Text



@Composable
fun ScreenB (nombre : String) {
    var valueState = "TAS FINO"
    var imcValue = 143.2
    var recomendationValue = "SIGUE COMO ESTAS"
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Pantalla B\n$nombre")
        Text(text = "RESULTADOS")
        Text(text = "IMC = $imcValue")
        Text(text = valueState)
        Text(text = recomendationValue)
    }
}