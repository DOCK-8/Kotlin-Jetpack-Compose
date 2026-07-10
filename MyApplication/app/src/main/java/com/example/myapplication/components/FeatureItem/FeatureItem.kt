package com.example.myapplication.components.FeatureItem

import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.Row

import androidx.compose.material3.Text
import androidx.compose.material3.Icon

import androidx.compose.ui.res.painterResource

@Composable
fun FeatureItem(
    featureData : FeatureViewData
){
    Row{
        Text(
            text = featureData.name
        )
        Icon(
            painter = painterResource(id = featureData.icon),
            contentDescription = ""
        )
    }
}