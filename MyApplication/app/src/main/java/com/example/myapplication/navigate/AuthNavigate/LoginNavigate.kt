package com.example.myapplication.navigate.AuthNavigate

//Route
import com.example.myapplication.navigate.Route
//End
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.views.Auth.LoginScreen
import com.example.myapplication.views.Auth.RegisterScreen

@Composable
fun LoginNavigate(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.Login.nameRoute
    ){
        composable(Route.Login.nameRoute){
            LoginScreen(navController)
        }
        composable(Route.Register.nameRoute){
            RegisterScreen()
        }
    }
}