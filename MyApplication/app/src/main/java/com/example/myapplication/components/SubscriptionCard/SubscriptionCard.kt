package com.example.myapplication.components.SubscriptionCard

import androidx.compose.runtime.Composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Text
import androidx.compose.material3.Button

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.colorResource

import com.example.myapplication.components.FeatureItem.FeatureItem

@Composable
fun SubscriptionCard(
    subscriptionData : SubscriptionViewData,
    type : SubscriptionCardType,
    clickFun : () -> Unit
) {

    val style = getStyleSubscriptionCard(type)
    val shape = RoundedCornerShape(16.dp)
   Column(
    modifier = Modifier
        .clip(shape)
        .background(colorResource(style.backgroundColor))
        .border(
            width = 4.dp,
            color = colorResource(style.borderColor),
            shape = shape 
        )
        .padding(20.dp)
   ){
    Text(
        text = subscriptionData.title
    )
    Column{
        subscriptionData.features.forEach{
            FeatureItem(
                featureData = it
            )
        }
    }
    Button(onClick = clickFun){
        Text(
            text = "SUSCRIBIRSE"
        )
    }
   }
}