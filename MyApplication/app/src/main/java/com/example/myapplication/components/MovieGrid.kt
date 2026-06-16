package com.example.myapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.models.data.MovieDetails
import com.example.myapplication.navigate.Route
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ViewModel.ProductDetailViewModel
import com.example.myapplication.ViewModel.CartViewModel

@Composable
fun MovieGrid(
    movies: List<MovieDetails>,
    navController: NavController? = null,
    modifier: Modifier = Modifier
) {
    val detailVm: ProductDetailViewModel = viewModel()
    val cartVm: CartViewModel = viewModel()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movies) { movie ->
            MovieGridItem(
                movie = movie,
                onAddToCart = {
                    cartVm.addToCart(movie)
                },
                onDetailsClick = {
                    detailVm.setSelectedMovie(movie)
                    navController?.navigate(Route.ProductDetail.nameRoute)
                }
            )
        }
    }
}

@Composable
fun MovieGridItem(
    movie: MovieDetails,
    onAddToCart: () -> Unit,
    onDetailsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(280.dp)
            .clickable { onDetailsClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A)),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            if (movie.primaryImageRes != null) {
                AsyncImage(
                    model = movie.primaryImageRes,
                    contentDescription = movie.primaryTitle,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .background(Color(0xFF2D2D2D)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "🎬",
                        style = MaterialTheme.typography.displayMedium
                    )
                }
            }

            // Movie info
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Text(
                    text = movie.primaryTitle,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 4.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${movie.startYear}",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(0xFFB0B0B0)
                    )

                    IconButton(
                        onClick = onAddToCart,
                        modifier = Modifier
                            .padding(0.dp)
                            .height(32.dp)
                    ) {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = "Agregar",
                            tint = Color(0xFFFF6B35),
                            modifier = Modifier
                                .height(20.dp)
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}
