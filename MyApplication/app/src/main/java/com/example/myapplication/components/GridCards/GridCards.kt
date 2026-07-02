package com.example.myapplication.components.GridCards

import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.ui.unit.dp

@Composable
fun GridCards (){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp)
    ){}
}