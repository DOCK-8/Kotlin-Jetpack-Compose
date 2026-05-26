package com.example.myapplication.models.repository

import com.example.myapplication.models.data.Thumbnail

fun getThumbnail(): Thumbnail {
    return Thumbnail(
        url = "https://cdn.myanimelist.net/images/anime/10/47347.jpg",
        width = 225,
        height = 319
    )
}
fun getListThumbnail() : List<Thumbnail> {
    return listOf(
        getThumbnail(),
        getThumbnail(),
        getThumbnail(),
    )
}