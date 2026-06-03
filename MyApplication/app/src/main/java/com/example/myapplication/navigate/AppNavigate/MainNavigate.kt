package com.example.myapplication.navigate.AppNavigate

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

// Routes
import com.example.myapplication.navigate.Route
// End

import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import com.example.myapplication.views.HomeScreen
import com.example.myapplication.views.ProductDetailScreen
import com.example.myapplication.views.CartScreen
import com.example.myapplication.views.User.ProfileScreen
// AppBottomBar and AppTopBar 
import com.example.myapplication.components.AppBottomBar
import com.example.myapplication.components.AppTopBar
// End
// mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
// End

@Composable
fun MainNavigate(){
    val navController = rememberNavController()
    var nameView by remember { mutableStateOf("Home") }
    Scaffold(
        topBar = {AppTopBar(nameView = nameView)},
        bottomBar = {AppBottomBar(navController = navController)},
        modifier = Modifier.fillMaxSize()
    ){ innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Route.Home.nameRoute
        ){
            composable(Route.Home.nameRoute){
                HomeScreen(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController
                )
                nameView = "Home"
            }
            composable(Route.Cart.nameRoute){
                CartScreen()
                nameView = "Carrito"
            }
            composable(Route.ProductDetail.nameRoute){
                ProductDetailScreen()
                nameView = "Detalle del producto"
            }
            composable(Route.Profile.nameRoute){
                ProfileScreen()
                nameView = "Perfil del usuario"
            }
        }
    }
}