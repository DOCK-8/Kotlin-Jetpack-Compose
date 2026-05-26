package com.example.myapplication.models.data

data class CastMember(
    val id: String,
    val url: String,
    val fullName: String,
    val primaryImage: String?,
    val thumbnails: List<Thumbnail>,
    val job: String,
    val characters: List<String>
)