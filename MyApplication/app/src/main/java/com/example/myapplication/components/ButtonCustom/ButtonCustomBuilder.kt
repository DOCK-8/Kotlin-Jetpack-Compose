package com.example.myapplication.components.ButtonCustom

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

import com.example.myapplication.R
import com.example.myapplication.components.AppIcon.AppIconType
import com.example.myapplication.components.AppIcon.AppIconType.EditProfile
import com.example.myapplication.components.AppIcon.AppIconType.Subscription

sealed class ButtonCustomType{
    object EditProfile : ButtonCustomType()
    object Subscription : ButtonCustomType()
}

data class ButtonDimention(
    val width : Dp,
    val height : Dp,
    val borderSize : Dp,
    val paddingSize : Dp
)
data class ButtonStyle(
    val backgroundColor : Int,
    val borderColor : Int,
)

fun getButtonStyle(type : ButtonCustomType) : ButtonStyle{
    return when(type){
        ButtonCustomType.EditProfile -> ButtonStyle(
            backgroundColor = R.color.inferno,
            borderColor = R.color.nullColor
        )
        ButtonCustomType.Subscription -> ButtonStyle(
            backgroundColor = R.color.inferno,
            borderColor = R.color.black
        )
    }
}

fun getButtonDimention(type : ButtonCustomType) : ButtonDimention{
    return when(type){
        ButtonCustomType.EditProfile -> ButtonDimention(
            width = 60.dp,
            height = 60.dp,
            borderSize = 0.dp,
            paddingSize = 15.dp
        )
        ButtonCustomType.Subscription -> ButtonDimention(
            width = 120.dp,
            height = 30.dp,
            borderSize = 4.dp,
            paddingSize = 10.dp
        )
    }
}
fun getIconType(type : ButtonCustomType) : AppIconType{
    return when(type){
        ButtonCustomType.EditProfile -> EditProfile
        ButtonCustomType.Subscription -> Subscription
    }
}
