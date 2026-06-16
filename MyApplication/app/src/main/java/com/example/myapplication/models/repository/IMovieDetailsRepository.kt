package com.example.myapplication.models.repository

import com.example.myapplication.models.data.MovieDetails

interface IMovieDetailsRepository {
    fun getMovies(): List<MovieDetails>
}

object MovieDetailsRepository : IMovieDetailsRepository {
    override fun getMovies(): List<MovieDetails> {
        return getListMovieDetails()
    }
}
