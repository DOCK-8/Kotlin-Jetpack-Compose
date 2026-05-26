package com.example.myapplication.navigate

sealed class Route(
    val nameRoute : String,
    val descriptionRoute : String
){
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
}