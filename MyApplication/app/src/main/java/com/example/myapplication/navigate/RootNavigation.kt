package com.example.myapplication.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
// Views
import com.example.myapplication.navigate.AuthNavigate.LoginNavigate
import com.example.myapplication.navigate.AppNavigate.MainNavigate
// End
// Session singleton
import com.example.myapplication.session.SessionManager
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
// End

@Composable
fun RootNavigation(){
    val logged by SessionManager.logged.collectAsState()
    if(logged)
        MainNavigate()
    else
        LoginNavigate()
}







/*
@Composable
fun RootNavigation() {

    val navController = rememberNavController()

    val logged by SessionManager.logged.collectAsState()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {

        composable("splash") {
            SplashScreen(
                onFinish = {
                    if (logged) {
                        navController.navigate("main_graph") {
                            popUpTo("splash") { inclusive = true }
                        }
                    } else {
                        navController.navigate("auth_graph") {
                            popUpTo("splash") { inclusive = true }
                        }
                    }
                }
            )
        }

        navigation(
            startDestination = "login",
            route = "auth_graph"
        ) {
            composable("login") {
                LoginScreen(
                    onLoginSuccess = {
                        SessionManager.login()

                        navController.navigate("main_graph") {
                            popUpTo("auth_graph") { inclusive = true }
                        }
                    }
                )
            }
        }

        navigation(
            startDestination = "home",
            route = "main_graph"
        ) {
            composable("home") {
                HomeScreen(
                    onLogout = {
                        SessionManager.logout()

                        navController.navigate("auth_graph") {
                            popUpTo("main_graph") { inclusive = true }
                        }
                    }
                )
            }
        }
    }
}
*/
