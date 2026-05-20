package com.example.myapplication.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

@Composable
fun ProductList(
    productos : List<String>
){
    LazyColumn{
        items(productos){producto ->
            ProductCard(
                nombre = producto,
                precio = 1500.0
            )
        }
    }
}