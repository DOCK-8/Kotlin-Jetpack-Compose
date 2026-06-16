package com.example.myapplication.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.models.data.MovieDetails
import com.example.myapplication.models.repository.IMovieDetailsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.example.myapplication.di.Singletons

class HomeViewModel(
    private val movieRepo: IMovieDetailsRepository = Singletons.Repositories.movieDetailsRepository
) : ViewModel() {
    private val _movieCatalog = MutableStateFlow<List<MovieDetails>>(emptyList())
    val movieCatalog: StateFlow<List<MovieDetails>> = _movieCatalog.asStateFlow()

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            val movies = movieRepo.getMovies()
            _movieCatalog.value = movies
        }
    }

    fun refresh() {
        loadMovies()
    }
}