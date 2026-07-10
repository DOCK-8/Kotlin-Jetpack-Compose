package com.example.myapplication.screens.catalog

import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.myapplication.R
import com.example.myapplication.components.SearchBar.SearchBar
import com.example.myapplication.components.MovieCard.MovieCard
import com.example.myapplication.components.MovieCard.MovieCardType.Catalog

@Composable
fun CatalogScreen (){
    val listTest = listOf("A","B","C","D","E","F","A","B","C","D","E","F","A","B","C","D","E","F")
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Adaptive(minSize = 170.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(3.dp)
    ){
        item(
            span = { GridItemSpan(maxLineSpan)}
        ){
            SearchBar()
        }
        items(listTest){
            movie -> MovieCard(
                textTest = movie,
                image = R.drawable.movie_1,
                type = Catalog
            )
        }
    }
}