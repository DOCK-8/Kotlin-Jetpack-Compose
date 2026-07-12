package com.example.myapplication.screens.subscription

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment

import androidx.compose.material3.Button
import androidx.compose.material3.Text

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.myapplication.components.SubscriptionCard.SubscriptionCard
import com.example.myapplication.components.SubscriptionCard.SubscriptionCardType.Basic
import com.example.myapplication.components.SubscriptionCard.SubscriptionCardType.Medium
import com.example.myapplication.components.SubscriptionCard.SubscriptionCardType.Advanced

@Composable
fun SubscriptionScreen (
    modifier : Modifier
){
    val viewModel : SubscriptionViewModel = viewModel(factory = SubscriptionViewModelFactory())
    val subscriptionPlans by viewModel.subscriptionPlans.collectAsState()
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        items(subscriptionPlans){
            SubscriptionCard(
                subscriptionData = it,
                type = when(it.plan){
                    1 -> Basic
                    2 -> Medium
                    3 -> Advanced
                    else -> Basic
                }
            ){}
        }
    }
}