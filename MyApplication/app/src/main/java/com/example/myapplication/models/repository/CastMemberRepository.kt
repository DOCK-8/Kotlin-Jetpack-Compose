package com.example.myapplication.models.repository

import com.example.myapplication.models.data.CastMember

fun getCastMember(): CastMember {
    return CastMember(
        id = "1",
        url = "",
        fullName = "Character Name",
        primaryImage = "https://cdn.myanimelist.net/images/anime/10/47347.jpg",
        thumbnails = listOf(getThumbnail()),
        job = "Main",
        characters = listOf("1 character", "2 character", "3 character"),
    )
}
fun getListCastMember() : List<CastMember> {
    return listOf(
        getCastMember(),
        getCastMember(),
        getCastMember(),
    )
}