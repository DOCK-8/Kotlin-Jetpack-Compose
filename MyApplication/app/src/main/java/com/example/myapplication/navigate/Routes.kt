package com.example.myapplication.navigate

sealed class Route(
    val nameRoute : String,
    val descriptionRoute : String
){
    object Login : Route(
        nameRoute = "Login",
        descriptionRoute = "Application Login"
    )
    object Register : Route(
        nameRoute = "Register",
        descriptionRoute = "Application Register Account"
    )
    object Main : Route(
        nameRoute = "Main",
        descriptionRoute = "Application main"
    )
    object Home : Route(
        nameRoute = "home",
        descriptionRoute = "Application View Home"
    )
    object Cart : Route(
        nameRoute = "cart",
        descriptionRoute = "Application View Cart"
    )
    object ProductDetail : Route(
        nameRoute = "product_detail",
        descriptionRoute = "Application View Product Detail"
    )
    object Profile : Route(
        nameRoute = "user_profile",
        descriptionRoute = "Application View User Profile"
    )
}