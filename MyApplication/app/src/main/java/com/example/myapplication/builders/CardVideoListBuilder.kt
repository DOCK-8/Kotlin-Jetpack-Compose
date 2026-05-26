package com.example.myapplication.builders

import androidx.compose.ui.graphics.Color

sealed class CardVideoListType {
    object Horizontal : CardVideoListType()
    object Grid : CardVideoListType()
}
sealed class CardVideoListSize {
    object Small : CardVideoListSize()
    object Medium : CardVideoListSize()
    object Large : CardVideoListSize()
}
sealed class CardVideoListSection {
    object Recomendados : CardVideoListSection()
    object Populares : CardVideoListSection()
    object Proximamente : CardVideoListSection()
    object VistosRecientemente : CardVideoListSection()
}
data class CardVideoListDimension(
    val width : Float,
    val height : Float
)
data class CardVideoListColor(
    val backgroundColor : Color,
    val contentColor : Color
)
fun getCardVideoListSize(size : CardVideoListSize) : Float{
    return when (size) {
        CardVideoListSize.Small -> 1f
        CardVideoListSize.Medium -> 1/3f
        CardVideoListSize.Large -> 3f
    }
}
fun getCardVideoListDimension(type : CardVideoListType, size : CardVideoListSize) : CardVideoListDimension{
    val base = getCardVideoListSize(size)
    return when (type) {
        CardVideoListType.Horizontal -> CardVideoListDimension(
            width = base * 300f,
            height = base * 150f
        )
        CardVideoListType.Grid -> CardVideoListDimension(
            width = base * 200f,
            height = base * 200f
        )
    }
}
fun getCardVideoListColor(section : CardVideoListSection) : CardVideoListColor{
    return when (section) {
        CardVideoListSection.Recomendados -> CardVideoListColor(
            backgroundColor = Color(0xFFE0F7FA),
            contentColor = Color(0xFF00796B)
        )
        CardVideoListSection.Populares -> CardVideoListColor(
            backgroundColor = Color(0xFFFFF3E0),
            contentColor = Color(0xFFFF6F00)
        )
        CardVideoListSection.Proximamente -> CardVideoListColor(
            backgroundColor = Color(0xFFEDE7F6),
            contentColor = Color(0xFF512DA8)
        )
        CardVideoListSection.VistosRecientemente -> CardVideoListColor(
            backgroundColor = Color(0xFFF3E5F5),
            contentColor = Color(0xFF9C27B0)
        )
    }
}