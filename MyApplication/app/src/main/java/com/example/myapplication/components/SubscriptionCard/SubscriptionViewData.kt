package com.example.myapplication.components.SubscriptionCard

import com.example.myapplication.components.FeatureItem.FeatureViewData

data class SubscriptionViewData (
   val title : String,
   val description : String,
   val price : Double,
   val features : List<FeatureViewData>
)