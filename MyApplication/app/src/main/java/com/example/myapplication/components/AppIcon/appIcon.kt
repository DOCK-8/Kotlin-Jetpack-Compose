package com.example.myapplication.components.AppIcon

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.State
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import com.example.myapplication.R

@Composable
fun appIcon(
    modifier : Modifier,
    type : AppIconType,
    iconDescription : String
)
{
    val transition = rememberInfiniteTransition(label = "icon_transition")
    val animation = when(type){
        AppIconType.SplashApp -> transition.animateColor(
            initialValue = colorResource(R.color.richMahogany),
            targetValue = colorResource(R.color.amberEarth),
            animationSpec = infiniteRepeatable(
                animation = tween(1000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "color"
        ).value
        AppIconType.EditProfile -> colorResource(R.color.white)
        AppIconType.Subscription -> colorResource(R.color.transparent)
    }
    val style = getIconStyle(type)
    Icon(
        painter = painterResource(style.icon),
        contentDescription = iconDescription,
        modifier = modifier.size(style.size),
        tint = animation
    )
}