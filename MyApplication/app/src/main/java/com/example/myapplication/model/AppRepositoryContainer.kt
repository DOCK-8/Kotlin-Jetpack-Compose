package com.example.myapplication.model

import com.example.myapplication.model.SubscriptionPlan.SubscriptionRepository
import com.example.myapplication.model.SubscriptionPlan.SubscriptionLocalRepository

object AppContainer{ 

    val subscriptionRepository: SubscriptionRepository = SubscriptionLocalRepository()
}