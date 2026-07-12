package com.example.myapplication.screens.subscription

import androidx.lifecycle.ViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

import com.example.myapplication.model.SubscriptionPlan.SubscriptionRepository
import com.example.myapplication.model.SubscriptionPlan.SubscriptionLocalRepository
import com.example.myapplication.model.SubscriptionPlan.SubscriptionPlan
import com.example.myapplication.model.SubscriptionPlan.FeaturePlan

import com.example.myapplication.components.FeatureItem.FeatureViewData
import com.example.myapplication.components.SubscriptionCard.SubscriptionViewData

import com.example.myapplication.R

class SubscriptionViewModel (
   private val repository : SubscriptionRepository
) : ViewModel (){

   private val _subscriptionPlans = MutableStateFlow<List<SubscriptionViewData>>(emptyList())
   val subscriptionPlans = _subscriptionPlans.asStateFlow()

   init{

      loadSubscriptionPlans()
   }

   private fun loadSubscriptionPlans(){

      val plans = repository.getSubscriptionPlans()
      _subscriptionPlans.value = plans.map{
         mapSubscriptionPlan(it)
      }
   }
   private fun mapSubscriptionPlan(subscriptionPlan : SubscriptionPlan) : SubscriptionViewData{

      return SubscriptionViewData(
         plan = subscriptionPlan.plan,
         title = subscriptionPlan.title,
         description = subscriptionPlan.description,
         price = subscriptionPlan.price,
         features = subscriptionPlan.features.map{
            mapFeaturePlan(it)
         }
      ) 
   }
   
   private fun mapFeaturePlan(featurePlan : FeaturePlan) : FeatureViewData{

      return FeatureViewData(
         name = featurePlan.nameFeature,
         icon = when(featurePlan.iconFeature){
            1 -> R.drawable.downloading
            2 -> R.drawable.display
            3 -> R.drawable.quality
            else -> R.drawable.users
         }
      )
   }
}