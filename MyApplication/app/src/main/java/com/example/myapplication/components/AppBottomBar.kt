package com.example.myapplication.components

import androidx.compose.runtime.Composable
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Text

@Composable
fun AppBottomBar(){
    NavigationBar{
        NavigationBarItem(
        selected = true,
        onClick = {},
        icon = {
            Icon(
                Icons.Default.Home,
                contentDescription = null
            )
        },
        label = {
            Text("Inicio")
        }
        )
        NavigationBarItem(
        selected = false,
        onClick = {},
        icon = {
            Icon(
                Icons.Default.ShoppingCart,
                contentDescription = null
            )
        },
        label = {
            Text("Carrito")
        }
        )
    }
}