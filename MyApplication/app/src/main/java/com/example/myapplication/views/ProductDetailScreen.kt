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

@Composable
fun ProductDetailScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        CardVideo(
            title = "Detalle del producto",
            size = Big
        ){}
    }
}