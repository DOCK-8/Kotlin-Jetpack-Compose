package com.example.myapplication.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.ViewModel.HomeViewModel
import com.example.myapplication.components.MovieHeader
import com.example.myapplication.builders.MovieHeaderSize
import com.example.myapplication.components.SearchBar
import com.example.myapplication.components.MovieSlider
import com.example.myapplication.components.MovieGrid

@Composable
fun HomeScreen(navController: NavController? = null, modifier: Modifier = Modifier){
    val vm: HomeViewModel = viewModel()
    val productos by vm.movieCatalog.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    val filteredMovies = if (searchQuery.isEmpty()) {
        productos
    } else {
        productos.filter {
            it.primaryTitle.contains(searchQuery, ignoreCase = true)
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF0F0F0F))
            .verticalScroll(rememberScrollState())
    ) {
        // Featured movie header
        if (productos.isNotEmpty()) {
            MovieHeader(
                movie = productos.first(),
                size = MovieHeaderSize.Large,
                onPlayClick = {}
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Search bar
        SearchBar(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = "Buscar películas..."
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Trending section
        if (productos.isNotEmpty()) {
            Text(
                text = "Tendencias",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            MovieSlider(
                movies = productos.take(6),
                navController = navController
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Grid of all movies
        Text(
            text = "Todas las películas",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))

        MovieGrid(
            movies = filteredMovies,
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp)
        )
    }
}