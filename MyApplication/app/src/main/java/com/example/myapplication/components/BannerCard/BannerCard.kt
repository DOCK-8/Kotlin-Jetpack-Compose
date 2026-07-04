package com.example.myapplication.components.BannerCard

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.myapplication.R

import com.example.myapplication.components.MovieCard.MovieCard
import com.example.myapplication.components.MovieCard.MovieCardType.Banner

@Composable
fun BannerCard (aspectratio : Float){
    MovieCard(
        textTest = "Banner",
        image = R.drawable.movie_2,
        type = Banner
    )
}