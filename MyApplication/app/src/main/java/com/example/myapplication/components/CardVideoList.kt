package com.example.myapplication.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.ui.unit.dp
// Card Video Import
import com.example.myapplication.builders.CardVideoType.Movie
import com.example.myapplication.builders.CardVideoType.Serie
import com.example.myapplication.builders.CardVideoType.Anime
import com.example.myapplication.builders.CardVideoForm.Rectangle
import com.example.myapplication.builders.CardVideoForm.Square
import com.example.myapplication.builders.CardVideoSize.Small
import com.example.myapplication.builders.CardVideoSize.Medium
// End Card Video Import
// Navigate Card Details
import androidx.navigation.NavController
import com.example.myapplication.navigate.Route
import com.example.myapplication.navigate.Route.ProductDetail
// End


@Composable
fun CardVideoList(
    productos : List<String>,
    navController : NavController? = null
){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp), 
    ){
        items(productos){producto ->
            CardVideo(
                title = producto,
            ){
                navController?.navigate(Route.ProductDetail.nameRoute)
            }
        }
    }
}