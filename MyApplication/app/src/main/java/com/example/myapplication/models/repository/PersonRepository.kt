package com.example.myapplication.models.repository

import com.example.myapplication.models.data.Person

fun getPerson(): Person {
    return Person(
        id = "1",
        url = "",
        fullName = "Voice Actor",
    )
}
fun getListDirectors() : List<Person> {
    return listOf(
        getPerson(),
        getPerson(),
        getPerson(),
    )
}
fun getListWriters() : List<Person> {
    return listOf(
        getPerson(),
        getPerson(),
        getPerson(),
    )
}