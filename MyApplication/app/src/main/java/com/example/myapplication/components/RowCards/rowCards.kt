package com.example.myapplication.components.RowCards

import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import com.example.myapplication.R

@Composable
fun rowCards(){
    LazyRow(
        modifier = Modifier
        .aspectRatio(1f)
        .fillMaxHeight()
    ){
        item{
            Box(
                modifier = Modifier
                .background(colorResource(id = R.color.black))
                .fillMaxWidth()
                .aspectRatio(1f)
            ){
                Text(
                    text = "Movie Grid",
                    color = colorResource(id = R.color.white)
                )
            } 
        }
        item{
            Box(
                modifier = Modifier
                .background(colorResource(id = R.color.goldenGlow))
                .fillMaxWidth()
                .aspectRatio(1f)
            ){
                Text(
                    text = "Movie Grid",
                    color = colorResource(id = R.color.white)
                )
            } 
        }
        item{
            Box(
                modifier = Modifier
                .background(colorResource(id = R.color.inferno))
                .fillMaxWidth()
                .aspectRatio(1f)
            ){
                Text(
                    text = "Movie Grid",
                    color = colorResource(id = R.color.white)
                )
            } 
        }
    }
}