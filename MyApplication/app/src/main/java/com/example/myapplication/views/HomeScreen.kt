package com.example.myapplication.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.ViewModel.CartViewModel
import com.example.myapplication.ViewModel.HomeViewModel
import com.example.myapplication.ViewModel.ProductDetailViewModel
import com.example.myapplication.builders.MovieHeaderSize
import com.example.myapplication.components.MovieHeader
import com.example.myapplication.components.MovieSlider
import com.example.myapplication.components.MovieGridItem
import com.example.myapplication.components.SearchBar
import com.example.myapplication.navigate.Route

@Composable
fun HomeScreen(navController: NavController? = null, modifier: Modifier = Modifier){
    val vm: HomeViewModel = viewModel()
    val cartVm: CartViewModel = viewModel()
    val detailVm: ProductDetailViewModel = viewModel()
    val productos by vm.movieCatalog.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    val filteredMovies = if (searchQuery.isEmpty()) {
        productos
    } else {
        productos.filter {
            it.primaryTitle.contains(searchQuery, ignoreCase = true)
        }
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF0F0F0F)),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    ) {
        if (productos.isNotEmpty()) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                MovieHeader(
                    movie = productos.first(),
                    size = MovieHeaderSize.Large,
                    onPlayClick = {
                        detailVm.setSelectedMovie(productos.first())
                        navController?.navigate(Route.ProductDetail.nameRoute)
                    }
                )
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Spacer(modifier = Modifier.height(24.dp))
            }
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            SearchBar(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = "Buscar películas..."
            )
        }
        item(span = { GridItemSpan(maxLineSpan) }) {
            Spacer(modifier = Modifier.height(24.dp))
        }

        if (productos.isNotEmpty()) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                Text(
                    text = "Tendencias",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(horizontal = 0.dp)
                )
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Spacer(modifier = Modifier.height(12.dp))
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                MovieSlider(
                    movies = productos.take(6),
                    navController = navController
                )
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Spacer(modifier = Modifier.height(32.dp))
            }
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            Text(
                text = "Todas las películas",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(horizontal = 0.dp)
            )
        }
        item(span = { GridItemSpan(maxLineSpan) }) {
            Spacer(modifier = Modifier.height(12.dp))
        }

        items(filteredMovies) { movie ->
            MovieGridItem(
                movie = movie,
                onAddToCart = {
                    cartVm.addToCart(movie)
                },
                onDetailsClick = {
                    detailVm.setSelectedMovie(movie)
                    navController?.navigate(Route.ProductDetail.nameRoute)
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
