package com.example.myapplication.screens.subscription

import androidx.compose.runtime.Composable

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items

import androidx.compose.ui.Modifier

import androidx.compose.material3.Button
import androidx.compose.material3.Text

import com.example.myapplication.components.SubscriptionCard.SubscriptionCard

@Composable
fun SubscriptionScreen (
    modifier : Modifier,
    viewModel : ViewModel
){
    LazyRow{
        items(pruebaList){
            shopp -> SubscriptionCard(shopp)
        }
    }
}