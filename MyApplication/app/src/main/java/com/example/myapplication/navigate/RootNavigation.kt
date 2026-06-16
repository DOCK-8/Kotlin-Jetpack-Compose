package com.example.myapplication.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.myapplication.navigate.Route
import com.example.myapplication.session.SessionManager
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.myapplication.views.Auth.LoginScreen
import com.example.myapplication.views.Auth.RegisterScreen
import com.example.myapplication.navigate.AppNavigate.MainNavigate

@Composable
fun RootNavigation(){
    val logged by SessionManager.logged.collectAsState()
    val navController = rememberNavController()

    if(logged) {
        MainNavigate()
    } else {
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
}