package com.example.myapplication.View

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.material3.Slider
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Spacer

@Composable
fun slider(){
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column {
        Row {
            Text(text = "ALTURA")
            Spacer(modifier = Modifier.size(50.dp))
            val altura = (sliderPosition * 3)
            Text(text = String.format("%.2f",altura))
        }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            modifier = Modifier.size(width = 250.dp, height = 80.dp)
        )
    }
}