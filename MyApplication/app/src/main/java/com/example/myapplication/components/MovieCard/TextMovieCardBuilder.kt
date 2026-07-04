package com.example.myapplication.components.MovieCard

import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

import com.example.myapplication.R

data class TextMovieCardDimention(
    val alignmentText: Alignment,
    val yText: Dp,
    val xText: Dp
)

data class TextMovieCardStyle(
    val colorPrimaryText : Int,
    val colorSecondaryText : Int,
    val colorScoreText : Int
)

fun getTextMovieCardStyle(type : MovieCardType) : TextMovieCardStyle{
    return when(type){
        MovieCardType.Catalog -> TextMovieCardStyle(
            colorPrimaryText = R.color.black,
            colorSecondaryText = R.color.black,
            colorScoreText = R.color.black
        )
        MovieCardType.Banner -> TextMovieCardStyle(
            colorPrimaryText = R.color.black,
            colorSecondaryText = R.color.black,
            colorScoreText = R.color.black
        )
        MovieCardType.Slider -> TextMovieCardStyle(
            colorPrimaryText = R.color.black,
            colorSecondaryText = R.color.black,
            colorScoreText = R.color.black
        )
    }
}

fun getTextMovieCardDimention(type: MovieCardType): TextMovieCardDimention {
    return when (type) {
        MovieCardType.Catalog -> TextMovieCardDimention(
            alignmentText = Alignment.BottomStart,
            yText = 0.dp,
            xText = 0.dp
        )

        MovieCardType.Banner -> TextMovieCardDimention(
            alignmentText = Alignment.CenterStart,
            yText = 0.dp,
            xText = 0.dp
        )

        MovieCardType.Slider -> TextMovieCardDimention(
            alignmentText = Alignment.BottomCenter,
            yText = 0.dp,
            xText = 0.dp
        )
    }
}