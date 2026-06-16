package com.example.myapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.models.data.CastMember
import com.example.myapplication.ui.theme.DarkSurfaceVariant

@Composable
fun CastCarousel(
    castList: List<CastMember>,
    modifier: Modifier = Modifier
) {
    if (castList.isEmpty()) return

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(castList) { actor ->
            CastCard(actor = actor)
        }
    }
}

@Composable
fun CastCard(
    actor: CastMember,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(140.dp)
                .background(
                    color = DarkSurfaceVariant,
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "♦",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Gray
            )
        }
        Text(
            text = actor.fullName,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier
                .width(100.dp),
            maxLines = 2
        )
        if (actor.characters.isNotEmpty()) {
            Text(
                text = actor.characters.first(),
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray,
                maxLines = 1
            )
        }
    }
}
