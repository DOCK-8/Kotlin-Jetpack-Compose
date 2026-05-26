package com.example.myapplication.components

import androidx.compose.runtime.Composable
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Text
import androidx.navigation.NavController
// import Routes
import com.example.myapplication.navigate.Route
import com.example.myapplication.navigate.Route.Home
import com.example.myapplication.navigate.Route.Cart

@Composable
fun AppBottomBar(navController : NavController){
    NavigationBar{
        NavigationBarItem(
        selected = true,
        onClick = {
            navController.navigate(Route.Home.nameRoute)
        },
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
        onClick = {
            navController.navigate(Route.Cart.nameRoute)
        },
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