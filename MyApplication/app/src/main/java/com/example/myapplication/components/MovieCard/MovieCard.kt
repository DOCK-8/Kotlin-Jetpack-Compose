package com.example.myapplication.components.MovieCard

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.myapplication.R

@Composable
fun MovieCard (
    modifier : Modifier = Modifier,
    textTest : String
){
    Box(
        modifier = modifier
        .background(colorResource(id = R.color.black))
    ){
        Text(
            text = "Movie Grid",
            color = colorResource(id = R.color.white)
        )
    } 
}