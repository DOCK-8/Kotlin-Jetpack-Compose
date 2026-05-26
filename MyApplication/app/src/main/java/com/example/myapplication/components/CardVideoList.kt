package com.example.myapplication.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
// Card Video Import
import com.example.myapplication.builders.CardVideoType.Movie
import com.example.myapplication.builders.CardVideoType.Serie
import com.example.myapplication.builders.CardVideoType.Anime
import com.example.myapplication.builders.CardVideoForm.Rectangle
import com.example.myapplication.builders.CardVideoForm.Square
import com.example.myapplication.builders.CardVideoSize.Small
import com.example.myapplication.builders.CardVideoSize.Medium
import com.example.myapplication.components.CardVideo
// End Card Video Import
// Navigate Card Details
import androidx.navigation.NavController
import com.example.myapplication.navigate.Route
import com.example.myapplication.navigate.Route.ProductDetail
// End
// Data MovieDetails
import com.example.myapplication.models.data.MovieDetails
// End


@Composable
fun CardVideoList(
    modifier : Modifier = Modifier,
    productos : List<MovieDetails>,
    navController : NavController? = null
){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        modifier = modifier,
    ){
        item(
            span = { GridItemSpan(maxLineSpan) }
        ){
            CardVideo(
                title = "Title",
                description = "Description",
                ranking = 4.5, duration = 120.0,
                form = Rectangle
                ){}
        }
        items(productos){producto ->
            CardVideo(
                title = producto.primaryTitle,
            ){
                navController?.navigate(Route.ProductDetail.nameRoute)
            }
        }
    }
}