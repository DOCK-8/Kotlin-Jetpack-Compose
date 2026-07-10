package com.example.myapplication.model.SubscriptionPlan

data class SubscriptionPlan(
    val id : Int,
    val title : String,
    val description : String,
    val price : Double,
    val features : List<FeaturePlan>
)