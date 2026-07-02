package com.example.myapplication.components.RowCards

import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import com.example.myapplication.R

import com.example.myapplication.components.MovieCard.MovieCard

@Composable
fun rowCards(){
    val listTest = listOf("A","B","C","D","E")
    LazyRow(
        modifier = Modifier
        .aspectRatio(16f/9f)
        .fillMaxHeight()
    ){
        items(listTest){
            movie -> MovieCard(
                textTest = movie,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
        }
    }
}