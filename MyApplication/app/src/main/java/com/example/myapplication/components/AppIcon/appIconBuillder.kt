package com.example.myapplication.components.AppIcon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

sealed class AppIconType{
    object SplashApp : AppIconType()
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
    }
}