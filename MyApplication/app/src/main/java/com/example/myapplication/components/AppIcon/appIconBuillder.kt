package com.example.myapplication.components.AppIcon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

sealed class AppIconType{
    object SplashApp : AppIconType()
    object EditProfile : AppIconType()
    object Subscription : AppIconType()
}

data class IconStyle(
    val size : Dp,
    val icon : Int
)

fun getIconStyle(type : AppIconType) : IconStyle{
    return when(type){
        AppIconType.SplashApp -> IconStyle(
            size = 110.dp,
            icon = R.drawable.splash_icon
        )
        AppIconType.EditProfile -> IconStyle(
            size = 24.dp,
            icon = R.drawable.edit_profile
        )
        AppIconType.Subscription -> IconStyle(
            size = 0.dp,
            icon = R.drawable.edit_profile
        )
    }
}