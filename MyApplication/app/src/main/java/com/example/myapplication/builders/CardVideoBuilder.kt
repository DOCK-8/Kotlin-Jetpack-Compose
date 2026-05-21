package com.example.myapplication.builders

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
    object Large : CardVideoSize()
}

data class CardVideoDimension(
    val width : Dp,
    val height : Dp,
    val shape : Shape
)

data class CardVideoColor(
    val backgroundColor : Color,
    val contentColor : Color
)

fun getCardVideoColors()