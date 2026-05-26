package com.example.myapplication.builders

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Shape
import androidx.compose.foundation.shape.RoundedCornerShape

sealed class CardVideoType {
    object Movie : CardVideoType()
    object Serie : CardVideoType()
    object Anime : CardVideoType()
}
sealed class CardVideoForm {
    object Square : CardVideoForm()
    object Rectangle : CardVideoForm()
}
sealed class CardVideoSize {
    object Small : CardVideoSize()
    object Medium : CardVideoSize()
    object Big : CardVideoSize()
}

data class CardVideoDimension(
    val width : Float,
    val aspectRatio : Float,
    val shape : Shape
)

data class CardVideoColor(
    val backgroundColor : Color,
    val borderColor : Color
)

fun getCardVideoColors(type : CardVideoType) : CardVideoColor{
    val background = Color.Transparent
    return when(type){
        CardVideoType.Movie -> CardVideoColor(
            backgroundColor = background,
            borderColor = Color(0xFFFF6400))
        CardVideoType.Serie -> CardVideoColor(
            backgroundColor = background,
            borderColor = Color(0xDDFF6400))
        CardVideoType.Anime -> CardVideoColor(
            backgroundColor = background,
            borderColor = Color(0xAAFF6400))
    }
}

fun getCardVideoSize(size : CardVideoSize) : Float{
    return when(size) {
        CardVideoSize.Small -> 0.3f
        CardVideoSize.Medium -> 0.5f
        CardVideoSize.Big -> 1f
    }

}

fun getCardVideoDimensions(form : CardVideoForm, size : CardVideoSize) : CardVideoDimension{
    val base = getCardVideoSize(size)
    val shape = RoundedCornerShape(8.dp)
    return when(form){
        CardVideoForm.Square -> CardVideoDimension(
            width = base,
            aspectRatio = 1f,
            shape = shape
        )
        CardVideoForm.Rectangle -> CardVideoDimension(
            width = 1f,
            aspectRatio = 2f / 1.3f ,
            shape = shape
        )
    }
}