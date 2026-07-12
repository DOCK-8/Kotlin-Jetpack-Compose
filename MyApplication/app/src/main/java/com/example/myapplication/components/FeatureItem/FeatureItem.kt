package com.example.myapplication.components.FeatureItem


import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size

import androidx.compose.material3.Text
import androidx.compose.material3.Icon

import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun FeatureItem(
    featureData : FeatureViewData
){
    Row{
        Icon(
            painter = painterResource(id = featureData.icon),
            contentDescription = "",
            modifier = Modifier.size(34.dp)
        )
        Text(
            text = featureData.name
        )
    }
}