package com.example.myapplication.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.models.data.MovieDetails
import com.example.myapplication.models.repository.getListMovieDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _movieCatalog = MutableStateFlow<List<MovieDetails>>(emptyList())
    val movieCatalog: StateFlow<List<MovieDetails>> = _movieCatalog.asStateFlow()

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            // In this simple project repository is a function; replace with DI if available
            val movies = getListMovieDetails()
            _movieCatalog.value = movies
        }
    }

    fun refresh() {
        loadMovies()
    }
}