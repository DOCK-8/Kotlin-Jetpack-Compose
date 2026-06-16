package com.example.myapplication.builders

sealed class MovieHeaderSize {
    data object Small : MovieHeaderSize()
    data object Medium : MovieHeaderSize()
    data object Large : MovieHeaderSize()
}

data class MovieHeaderDimensions(
    val width: Float,
    val height: Float
)

fun getMovieHeaderDimensions(size: MovieHeaderSize): MovieHeaderDimensions {
    return when (size) {
        MovieHeaderSize.Small -> MovieHeaderDimensions(width = 0.5f, height = 0.3f)
        MovieHeaderSize.Medium -> MovieHeaderDimensions(width = 1f, height = 0.5f)
        MovieHeaderSize.Large -> MovieHeaderDimensions(width = 1f, height = 0.6f)
    }
}
