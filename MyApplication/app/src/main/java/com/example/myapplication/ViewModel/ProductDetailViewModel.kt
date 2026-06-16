package com.example.myapplication.ViewModel

import androidx.lifecycle.ViewModel
import com.example.myapplication.models.data.MovieDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductDetailViewModel : ViewModel() {
    private val _selectedMovie = MutableStateFlow<MovieDetails?>(null)
    val selectedMovie: StateFlow<MovieDetails?> = _selectedMovie.asStateFlow()

    fun setSelectedMovie(movie: MovieDetails) {
        _selectedMovie.value = movie
    }

    fun getSelectedMovie(): MovieDetails? = _selectedMovie.value

    fun clearSelection() {
        _selectedMovie.value = null
    }
}
