package com.example.myapplication.model.SubscriptionPlan

interface SubscriptionRepository {
    fun getSubscriptionPlans () : List<SubscriptionPlan>
}