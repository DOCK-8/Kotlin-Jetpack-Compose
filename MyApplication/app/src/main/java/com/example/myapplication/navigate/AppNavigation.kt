package com.example.myapplication.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.myapplication.views.HomeScreen
import com.example.myapplication.views.ProductDetailScreen
import com.example.myapplication.views.CartScreen
// Add Nex Views

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.Home.nameRoute
    ){
        composable(Route.Home.nameRoute){
            HomeScreen(navController = navController)
        }
        composable(Route.Cart.nameRoute){
            CartScreen(navController = navController)
        }
        composable(Route.ProductDetail.nameRoute){
            ProductDetailScreen(navController = navController)
        }
    }
}