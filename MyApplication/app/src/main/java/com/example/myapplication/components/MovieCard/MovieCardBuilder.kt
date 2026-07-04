package com.example.myapplication.components.MovieCard

import com.example.myapplication.R

sealed class MovieCardType{
    object Catalog : MovieCardType ()
    object Banner : MovieCardType ()
    object Slider : MovieCardType ()
}

data class MovieCardStyle(
    val backgroundColor : Int,
    val overlayColor : Int,
    val aspectRatio : Float
)

fun getMovieCardStyle (type : MovieCardType) : MovieCardStyle{
    return when(type){
        MovieCardType.Catalog -> MovieCardStyle(
            backgroundColor = R.color.black,
            overlayColor = R.color.transparent,
            aspectRatio = 2f / 3f
        )
        MovieCardType.Banner -> MovieCardStyle(
            backgroundColor = R.color.black,
            overlayColor = R.color.transparent,
            aspectRatio = 20f/12f
        )
        MovieCardType.Slider -> MovieCardStyle(
            backgroundColor = R.color.black,
            overlayColor = R.color.transparent,
            aspectRatio = 15f / 18f
        )
    }
}