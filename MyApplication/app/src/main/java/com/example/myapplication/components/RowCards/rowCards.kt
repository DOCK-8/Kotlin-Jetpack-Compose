package com.example.myapplication.components.RowCards

import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import com.example.myapplication.R

import com.example.myapplication.components.MovieCard.MovieCard
import com.example.myapplication.components.MovieCard.MovieCardType.Slider

@Composable
fun rowCards(){
    val listTest = listOf(
        R.drawable.movie_1,
        R.drawable.movie_2,
        R.drawable.movie_3,
        R.drawable.movie_1,
        R.drawable.movie_2,
        R.drawable.movie_3
    )
    val stateLazyRow = rememberLazyListState()
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        state = stateLazyRow,
        modifier = Modifier
        .aspectRatio(1f)
        .fillMaxHeight()
    ){
        items(listTest){
            movie -> MovieCard(
                textTest = "${stateLazyRow.firstVisibleItemIndex}",
                image = movie,
                type = Slider
            )
        }
    }
}