package com.example.myapplication.builders

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Shape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

sealed class SingleButtonType {
    object Play : SingleButtonType()
    object Watch : SingleButtonType()
    object AnimeView : SingleButtonType()
    object View : SingleButtonType()
}

sealed class SingleButtonForm{
    object Circle : SingleButtonForm()
    object Square : SingleButtonForm()
    object Rectangle : SingleButtonForm()
}
sealed class SingleButtonSize{
    object Small : SingleButtonSize()
    object Medium : SingleButtonSize()
    object Large : SingleButtonSize()
}

data class SingleButtonDimension(
    val width : Float,
    val height : Float,
    val shape : Shape
)

data class SingleButtonColor(
    val backgroundColor : Color,
    val contentColor : Color
)

fun getSingleButtonFontSize(size : SingleButtonSize) : TextUnit{
    return when (size) {
        SingleButtonSize.Small -> 8.sp
        SingleButtonSize.Medium -> 10.sp
        SingleButtonSize.Large -> 13.sp
    }
}

fun getSingleButtonSizeBase(size : SingleButtonSize) : Float{
    return when (size) {
        SingleButtonSize.Small -> 0.18f
        SingleButtonSize.Medium -> 1f
        SingleButtonSize.Large -> 3f
    }
}

fun getSingleButtonDimension(form : SingleButtonForm, size : SingleButtonSize) : SingleButtonDimension{
    val base = getSingleButtonSizeBase(size)
    return when (form) {
        SingleButtonForm.Circle  -> SingleButtonDimension(
            base,
            base,
            CircleShape
        )
        SingleButtonForm.Square -> SingleButtonDimension(
            base,
            base,
            RoundedCornerShape(3.dp)
        )
        SingleButtonForm.Rectangle -> SingleButtonDimension(
            base * 2,
            base,
            RoundedCornerShape(8.dp)
        )
    }
}

fun getSingleButtonColors(type : SingleButtonType) : SingleButtonColor{
    return when (type) {
        SingleButtonType.Play -> SingleButtonColor(
            backgroundColor = Color(0x99FF6400),
            contentColor = Color(0xFFFFFFFF)
        )
        SingleButtonType.Watch -> SingleButtonColor(
            backgroundColor = Color(0xFFFF6400),
            contentColor = Color(0xFFFFFFFF)
        )
        SingleButtonType.AnimeView -> SingleButtonColor(
            backgroundColor = Color(0x22000000),
            contentColor = Color(0xFFFFFFFF)
        )
        SingleButtonType.View -> SingleButtonColor(
            backgroundColor = Color(0x00000000),
            contentColor = Color(0xFFFFFFFF)
        )
    }
}