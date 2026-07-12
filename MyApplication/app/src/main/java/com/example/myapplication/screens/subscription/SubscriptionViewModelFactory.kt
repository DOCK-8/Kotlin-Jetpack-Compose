package com.example.myapplication.screens.subscription

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel

import com.example.myapplication.model.AppContainer

class SubscriptionViewModelFactory : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return SubscriptionViewModel(
            AppContainer.subscriptionRepository
        ) as T    
    }
}