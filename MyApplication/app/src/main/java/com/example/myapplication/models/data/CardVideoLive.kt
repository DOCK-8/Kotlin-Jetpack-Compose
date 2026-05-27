package com.example.myapplication.models.data

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

object store {
 var carts by mutableStateOf(listOf<MovieDetails>())
 var cartSelected by mutableStateOf<MovieDetails?>(null)
}