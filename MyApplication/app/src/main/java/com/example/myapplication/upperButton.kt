package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun upperButton(attribute : String, dataValue : Int) {
    Column(Modifier.clip(shape = RoundedCornerShape(10.dp)).background(Color(0xFFEDEDE9)).padding(20.dp)) {
        var upperValue by remember {
            mutableFloatStateOf(0f)
        }
        Text(text = attribute, fontSize = 8.sp)
        Text(text = String.format("%.2f",upperValue), fontSize = 14.sp)
        Row {
            Button(onClick = {
                upperValue+=0.1f
            },colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBC6C25))) {
                Text(text = "+")
            }
            Button(onClick = {
                upperValue-=0.1f
            },colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBC6C25))) {
                Text(text = "-")
            }
        }
    }
}