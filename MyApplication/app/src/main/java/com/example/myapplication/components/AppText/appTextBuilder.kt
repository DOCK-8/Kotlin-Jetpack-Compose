package com.example.myapplication.components.AppText

import com.example.myapplication.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

sealed class AppTextType{
    object SplashAppName : AppTextType()
    object SplashPhrase : AppTextType()
    object Head : AppTextType()
}
sealed class AppTextSize{
    object Small : AppTextSize()
    object Medium : AppTextSize()
    object Big : AppTextSize()
}

data class AppTextStyle(
    val color : Int,
    val bold : Int
)

fun getAppTextStyle (type : AppTextType) : AppTextStyle{
    return when(type){
        AppTextType.SplashAppName -> AppTextStyle(
            color = R.color.goldenGlow,
            bold = 700
        )
        /* PENDIENTE DESING DE GRADIENTE DE LA FRASE */
        AppTextType.SplashPhrase -> AppTextStyle(
            color = R.color.white,
            bold = 200
        )
        AppTextType.Head -> AppTextStyle(
            color = R.color.amberEarth,
            bold = 400
        )
    }
}

fun getAppTextSize (type : AppTextSize) : TextUnit {
    return when(type){
        AppTextSize.Small -> 15.sp
        AppTextSize.Medium -> 30.sp
        AppTextSize.Big -> 50.sp
    }
}