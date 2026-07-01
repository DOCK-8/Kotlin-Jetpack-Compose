package com.example.myapplication.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import com.example.myapplication.R
import com.example.myapplication.components.RowCards.rowCards

@Composable
fun HomeScreen(){
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ){
        item{
            Box(
                modifier = Modifier
                .background(colorResource(id = R.color.goldenGlow))
                .fillMaxWidth()
                .aspectRatio(0.5f)
            ){
                Text(
                    text = "Movie Grid",
                    color = colorResource(id = R.color.white)
                )
            } 
        }
        item{
            rowCards()
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