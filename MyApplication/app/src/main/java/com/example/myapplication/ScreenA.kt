package com.example.myapplication

import com.example.myapplication.R

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.size
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

//Color HX
import androidx.compose.ui.graphics.Color

import androidx.navigation.NavController

import androidx.compose.ui.res.painterResource
//Add Mutable Variable
import androidx.compose.runtime.remember

import com.example.myapplication.Person

@Composable
fun ScreenA (navController : NavController) {
    val Persona = Person(0,0,0f,0f)
    val widthButton = 150.dp
    val heightButton = 250.dp
    val iconSize = 60.dp
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Indice de Masa Corporal", fontSize = 20.sp)
        Text(text = "Ingrese y seleccione la siguiente informacion", color = Color(0xFFADADAD), fontSize = 10.sp)
        val icona : Int = R.drawable.man
        val iconb : Int = R.drawable.woman
        Row{
            ButtonGender(widthButton, heightButton, icona, "Masculino", iconSize, Persona)
            Spacer(modifier = Modifier.size(20.dp))
            ButtonGender(widthButton, heightButton, iconb, "Femenino", iconSize, Persona)
            Text(text = "${Persona.gender}")
        }
        slider()
        Row{
            upperButton("Peso KG", 0.5f)
            Spacer(modifier = Modifier.size(width = 20.dp, height = 1.dp))
            upperButton("Edad", 1.0f)
        }
        Button( onClick = {
            navController.navigate(Routes.ScreenB+"/JulioProfe")
        }){
            Text(text = "CALCULAR")
        }
    }

}