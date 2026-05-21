package com.example.myapplication

import com.example.myapplication.builders.SingleButtonForm
import com.example.myapplication.builders.SingleButtonType
import com.example.myapplication.components.AppBottomBar
import com.example.myapplication.components.AppTopBar
import com.example.myapplication.components.PrimaryButtons
import com.example.myapplication.components.SearchBar
import com.example.myapplication.components.ProductList
import com.example.myapplication.components.ProductCard
import com.example.myapplication.components.SingleButton
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun HomeScreen(){
    var text by remember {mutableStateOf("")}
    val productos = listOf(
        "articulo1",
        "articulo2",
        "articulo3",
        "articulo4",
        "articulo5",
    )
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
    SingleButton(onClick = {}, text = "Play", form = SingleButtonForm.Circle, type = SingleButtonType.View)
    SingleButton(onClick = {}, text = "Play", form = SingleButtonForm.Square, type = SingleButtonType.Watch)
    SingleButton(onClick = {}, text = "Play", form = SingleButtonForm.Rectangle, type = SingleButtonType.AnimeView)
    }

    /*
    Scaffold(
        topBar = {AppTopBar()},
        bottomBar = {AppBottomBar()},
        modifier = Modifier.fillMaxSize()
    ){ innerPadding ->
        Column ( modifier = Modifier.padding(innerPadding)){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            SearchBar(
                value = text,
                onValueChange = {text = it},
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            PrimaryButtons(
                text = " Buscar",
                modifier = Modifier.wrapContentWidth(),
                onClick = {}
            )                        }
            Spacer(modifier = Modifier.height(16.dp))
            ProductList(productos = productos)
        }
    }
   */ 
}