package com.example.myapplication.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.RatingGold

@Composable
fun RatingBar(
    rating: Double,
    maxRating: Double = 10.0,
    modifier: Modifier = Modifier,
    showText: Boolean = true
) {
    val normalizedRating = (rating / maxRating * 5).coerceIn(0.0, 5.0)
    val fullStars = normalizedRating.toInt()
    val hasPartialStar = normalizedRating % 1 > 0

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(5) { index ->
            if (index < fullStars) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null,
                    tint = RatingGold,
                    modifier = Modifier.width(16.dp)
                )
            } else if (index == fullStars && hasPartialStar) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null,
                    tint = RatingGold,
                    modifier = Modifier.width(16.dp)
                )
            } else {
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.width(16.dp)
                )
            }
        }

        if (showText) {
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = String.format("%.1f", rating),
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}
