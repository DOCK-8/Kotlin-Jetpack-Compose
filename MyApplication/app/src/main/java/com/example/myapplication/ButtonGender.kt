package com.example.myapplication

import com.example.myapplication.R

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.myapplication.Person

@Composable
fun ButtonGender (widthButton : Dp, heightButton : Dp, iconWhere : Int, gender : String, iconSize : Dp, Persona : Person){
    Button( 
        onClick = {
           Persona.gender = 2
        },
        shape = RoundedCornerShape(20.dp), 
        modifier = Modifier.size(width = widthButton, height = heightButton)) 
    { 
        Image(
        painter = painterResource(id = iconWhere),
        contentDescription = "Person Gender $gender",
        modifier = Modifier.size(width = iconSize, height = iconSize),
        )
    }
}