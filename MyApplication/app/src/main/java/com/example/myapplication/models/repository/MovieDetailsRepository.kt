package com.example.myapplication.models.repository

import com.example.myapplication.R
import com.example.myapplication.models.data.MovieDetails

fun getMovieDetails(): MovieDetails {
    return MovieDetails(
        id = "1",
        url = "url-elemento",
        primaryTitle = "Movie Title si es",
        originalTitle = "Original Movie Title",
        type = "Movie",
        description = "Movie Description",
        thumbnails = getListThumbnail(),
        startYear = 2020,
        interests = listOf("Interest 1", "Interest 2", "Interest 3"),
        countriesOfOrigin = listOf("Country 1", "Country 2"),
        externalLinks = listOf("External Link 1", "External Link 2"),
        spokenLanguages = listOf("Language 1", "Language 2"),
        filmingLocations = listOf("Location 1", "Location 2"),
        productionCompanies = getListProductionCompany(),
        genres = listOf("Genre 1", "Genre 2"),
        isAdult = false,
        directors = getListDirectors(),
        writers = getListWriters(),
        cast = getListCastMember(),
    )
}
fun getListMovieDetails() : List<MovieDetails> {
    fun buildMovie(
        id: String,
        title: String,
        imageRes: Int,
        year: Int
    ): MovieDetails {
        return MovieDetails(
            id = id,
            url = "url-$id",
            primaryTitle = title,
            originalTitle = "$title Original",
            type = "Movie",
            description = "Descripción de $title",
            primaryImageRes = imageRes,
            thumbnails = getListThumbnail(),
            startYear = year,
            interests = listOf("Acción", "Aventura", "Suspenso"),
            countriesOfOrigin = listOf("Estados Unidos"),
            externalLinks = listOf("https://example.com/$id"),
            spokenLanguages = listOf("Inglés"),
            filmingLocations = listOf("Estudios"),
            productionCompanies = getListProductionCompany(),
            genres = listOf("Acción", "Ciencia ficción"),
            isAdult = false,
            directors = getListDirectors(),
            writers = getListWriters(),
            cast = getListCastMember(),
        )
    }
    return listOf(
        buildMovie("1", "Noche de Escape", R.drawable.p2, 2022),
        buildMovie("2", "Planeta de Héroes", R.drawable.p2, 2023),
        buildMovie("3", "Misión Secreta", R.drawable.p1, 2024),
    )
}