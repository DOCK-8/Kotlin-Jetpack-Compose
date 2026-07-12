package com.example.myapplication.components.SubscriptionCard

import com.example.myapplication.R

sealed class SubscriptionCardType{
    object Basic : SubscriptionCardType()
    object Medium : SubscriptionCardType()
    object Advanced : SubscriptionCardType()
}

data class StyleSubscriptionCard(
    val borderColor : Int,
    val backgroundColor : Int,
)

fun getStyleSubscriptionCard(type : SubscriptionCardType) : StyleSubscriptionCard{
    return when (type){
        SubscriptionCardType.Basic -> StyleSubscriptionCard(
            borderColor = R.color.white,
            backgroundColor = R.color.blackTransparent
        )
        SubscriptionCardType.Medium -> StyleSubscriptionCard(
            borderColor = R.color.goldenGlow,
            backgroundColor = R.color.blackTransparent
        )
        SubscriptionCardType.Advanced -> StyleSubscriptionCard(
            borderColor = R.color.white,
            backgroundColor = R.color.blackTransparent
        )
    }
}