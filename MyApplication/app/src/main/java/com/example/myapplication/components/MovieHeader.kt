package com.example.myapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.builders.MovieHeaderSize
import com.example.myapplication.builders.getMovieHeaderDimensions
import com.example.myapplication.models.data.MovieDetails

@Composable
fun MovieHeader(
    movie: MovieDetails,
    size: MovieHeaderSize = MovieHeaderSize.Large,
    modifier: Modifier = Modifier,
    onPlayClick: () -> Unit = {}
) {
    val dimensions = getMovieHeaderDimensions(size)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height((dimensions.height * 400).dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height((dimensions.height * 400).dp)
                .background(Color.DarkGray)
        )

        // Gradient overlay
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height((dimensions.height * 400).dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.7f)
                        )
                    )
                )
        )

        // Content
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Text(
                text = movie.primaryTitle,
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 28.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "${movie.startYear} • ${movie.runtimeMinutes ?: 0} min",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.LightGray,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            SingleButton(
                type = com.example.myapplication.builders.SingleButtonType.Play,
                form = com.example.myapplication.builders.SingleButtonForm.Circle,
                size = com.example.myapplication.builders.SingleButtonSize.Medium
            ) {
                onPlayClick()
            }
        }
    }
}
