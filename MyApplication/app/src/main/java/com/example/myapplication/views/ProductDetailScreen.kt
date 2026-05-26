package com.example.myapplication.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.navigation.NavController
// Card Video Import
import com.example.myapplication.components.CardVideo
import com.example.myapplication.builders.CardVideoSize
import com.example.myapplication.builders.CardVideoSize.Big
// End
// Single Button Import
import com.example.myapplication.components.SingleButton
import com.example.myapplication.builders.SingleButtonForm.Rectangle
import com.example.myapplication.builders.SingleButtonSize.Medium
import com.example.myapplication.builders.SingleButtonType.Watch
// End
// Data MovieDetails
import com.example.myapplication.models.data.MovieDetails
// End

@Composable
fun ProductDetailScreen(movieDetails : MovieDetails){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        CardVideo(
            title = movieDetails.primaryTitle,
            size = Big
        ){}
        SingleButton(
            text = "Agregar al carrito",
            type = Watch,
            form = Rectangle,
            size = Medium
        ){

        }
    }
}