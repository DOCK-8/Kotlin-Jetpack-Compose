package com.example.myapplication.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.models.data.MovieDetails
import com.example.myapplication.builders.CardVideoSize

@Composable
fun MovieSlider(
    movies: List<MovieDetails>,
    navController: NavController? = null,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        movies.forEach { movie ->
            CardVideo(
                title = movie.primaryTitle,
                size = CardVideoSize.Small,
                modifier = Modifier.height(200.dp)
            ) {
                // Handle click
            }
        }
    }
}
