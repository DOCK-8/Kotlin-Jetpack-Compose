package com.example.myapplication.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.navigation.NavController
// Add Card List
import com.example.myapplication.components.CardVideoList
// End
// Add data Card Live
import com.example.myapplication.models.data.store
// End

@Composable
fun CartScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        CardVideoList(
            productos = store.carts
        )
    }
}