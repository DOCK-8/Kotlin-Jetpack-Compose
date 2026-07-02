package com.example.myapplication.screens.home

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.myapplication.components.BannerCard.BannerCard
import com.example.myapplication.components.MovieCard.MovieCard
import com.example.myapplication.components.RowCards.rowCards

@Composable
fun HomeScreen(){
    val listTest = listOf("A","B","C","D","E","F","A","B","C","D","E","F","A","B","C","D","E","F")
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Adaptive(minSize = 128.dp)
    ){
        item(span = { GridItemSpan(maxLineSpan)}) {
            BannerCard(16f/9f)
        }
        item(span = { GridItemSpan(maxLineSpan)}) {
            rowCards()
        }
        items(listTest){
            movie -> MovieCard(
                textTest = movie,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
        }
    }
}