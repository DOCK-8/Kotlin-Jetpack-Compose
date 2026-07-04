package com.example.myapplication.components.MovieCard

import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource

import com.example.myapplication.R

@Composable
fun TextMovieCard(
    dataMovie: List<String>,
    type: MovieCardType,
    modifier: Modifier
) {
    val styleText: TextMovieCardStyle = getTextMovieCardStyle(type)

    Column(
        modifier = modifier
    ) {
        dataMovie.forEach { dataM ->
            Text(
                text = dataM,
                color = colorResource(id = styleText.colorPrimaryText)
            )
        }
    }
}