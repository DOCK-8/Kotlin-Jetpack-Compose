package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable

fun AppNavigation () {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.ScreenA, builder = {
        composable(Routes.ScreenA){
            ScreenA(navController)
        }
        composable(Routes.ScreenB+"/{nombre}"){
            var nombre = it.arguments?.getString("nombre")
            ScreenB(nombre?:"no tiene nombre")
        }
    })
}