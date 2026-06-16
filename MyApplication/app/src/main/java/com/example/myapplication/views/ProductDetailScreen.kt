package com.example.myapplication.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.components.CardVideo
import com.example.myapplication.builders.CardVideoSize.Big
import com.example.myapplication.components.SingleButton
import com.example.myapplication.builders.SingleButtonForm.Rectangle
import com.example.myapplication.builders.SingleButtonSize.Medium
import com.example.myapplication.builders.SingleButtonType.Watch
import com.example.myapplication.ViewModel.ProductDetailViewModel
import com.example.myapplication.ViewModel.CartViewModel
import com.example.myapplication.components.RatingBar
import com.example.myapplication.components.GenreChips
import com.example.myapplication.components.CastCarousel
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp as dpUnit

@Composable
fun ProductDetailScreen(navController: NavController? = null, modifier: Modifier = Modifier){
    val detailVm: ProductDetailViewModel = viewModel()
    val cartVm: CartViewModel = viewModel()
    val selectedMovie by detailVm.selectedMovie.collectAsState()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF0F0F0F))
    ){
        if (selectedMovie != null) {
            // Header using CardVideo to present selected movie card
            item {
                CardVideo(
                    title = selectedMovie!!.primaryTitle,
                    description = selectedMovie!!.description,
                    ranking = selectedMovie!!.averageRating ?: 0.0,
                    duration = selectedMovie!!.runtimeMinutes?.toDouble() ?: 0.0,
                    form = com.example.myapplication.builders.CardVideoForm.Rectangle,
                    size = Big,
                    img = selectedMovie!!.primaryImageRes,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(320.dp)
                ){
                    // on click of the card in detail screen could open player
                }
            }

            item {
                Column(
                    modifier = Modifier.padding(16.dp)
                ){
                    // Title section
                    Text(
                        text = selectedMovie!!.primaryTitle,
                        style = MaterialTheme.typography.headlineLarge,
                        fontSize = 26.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    // Metadata row
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = "${selectedMovie!!.startYear}",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )
                        Text(
                            text = "•",
                            color = Color.Gray
                        )
                        Text(
                            text = "${selectedMovie!!.runtimeMinutes ?: 0} min",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )
                        if (selectedMovie!!.averageRating != null) {
                            RatingBar(
                                rating = selectedMovie!!.averageRating!!,
                                maxRating = 10.0,
                                showText = true
                            )
                        }
                    }

                    // Genres
                    if (selectedMovie!!.genres.isNotEmpty()) {
                        GenreChips(
                            genres = selectedMovie!!.genres,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }

                    // Synopsis section
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A))
                    ){
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ){
                            Text(
                                text = "Sinopsis",
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )

                            Text(
                                text = selectedMovie!!.description,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color(0xFFB0B0B0)
                            )
                        }
                    }

                    // Director info
                    if (selectedMovie!!.directors.isNotEmpty()) {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A))
                        ){
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ){
                                Text(
                                    text = "Director",
                                    style = MaterialTheme.typography.titleMedium,
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )

                                Text(
                                    text = selectedMovie!!.directors.first().fullName,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }

                    // Cast section
                    if (selectedMovie!!.cast.isNotEmpty()) {
                        Column(
                            modifier = Modifier.padding(bottom = 16.dp)
                        ){
                            Text(
                                text = "Elenco",
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.padding(bottom = 12.dp)
                            )
                            CastCarousel(
                                castList = selectedMovie!!.cast
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Action buttons
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ){
                        SingleButton(
                            text = "➕ Carrito",
                            type = Watch,
                            form = Rectangle,
                            size = Medium,
                            modifier = Modifier.weight(1f)
                        ){
                            cartVm.addToCart(selectedMovie!!)
                        }

                        SingleButton(
                            text = "⭐ Favorito",
                            type = Watch,
                            form = Rectangle,
                            size = Medium,
                            modifier = Modifier.weight(1f)
                        ){
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        } else {
            item {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text(
                        text = "🎬",
                        fontSize = 64.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = "Selecciona una película",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}