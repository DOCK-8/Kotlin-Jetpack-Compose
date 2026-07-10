package com.example.myapplication.components.SubscriptionCard

import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.Text
import androidx.compose.material3.Button

import com.example.myapplication.components.FeatureItem.FeatureItem

@Composable
fun SubscriptionCard(
   subscriptionData : SubscriptionViewData 
) {
   Box{
    Text(
        text = subscriptionData.title
    )
    LazyColumn{
        items(subscriptionData.features){
            FeatureItem(
                featureData = it
            )
        }
    }
    Button(onClick = {}){
        Text(
            text = "SUSCRIBIRSE"
        )
    }
   }
}