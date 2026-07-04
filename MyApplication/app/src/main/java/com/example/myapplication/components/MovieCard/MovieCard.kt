package com.example.myapplication.components.MovieCard

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import com.example.myapplication.R

@Composable
fun MovieCard (
    modifier : Modifier = Modifier,
    type : MovieCardType,
    textTest : String,
    image : Int
){
    val style = getMovieCardStyle(type)
    val positionText: TextMovieCardDimention = getTextMovieCardDimention(type)
    Box(
        modifier = modifier
        .background(colorResource( id = style.backgroundColor))
        .fillMaxSize()
        .aspectRatio(style.aspectRatio)
    ){
        Image(
            painter = painterResource( id = image),
            contentDescription = "Description",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        ) 
        Box(modifier = Modifier.fillMaxSize().background(colorResource( id = style.overlayColor)))
        TextMovieCard(
            dataMovie = listOf(textTest,"4.5"),
            type = type,
            modifier = Modifier
            .align(positionText.alignmentText)
            .offset(
                x = positionText.xText,
                y = positionText.yText
            )
        )
    } 
}
