package com.example.myapplication.screens.subscription

import androidx.lifecycle.ViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

import com.example.myapplication.model.SubscriptionPlan.SubscriptionRepository
import com.example.myapplication.model.SubscriptionPlan.SubscriptionPlan
import com.example.myapplication.model.SubscriptionPlan.FeaturePlan

import com.example.myapplication.components.FeatureItem.FeatureViewData
import com.example.myapplication.components.SubscriptionCard.SubscriptionViewData

class SubscriptionViewModel (
   private val repository : SubscriptionRepository,
) : ViewModel {
   private val _subscriptionPlans = MutableStateFlow<List<SubscriptionViewData>>(emptyList())
   val subscriptionPlans = _subscriptionPlans.asStateFlow()

   fun mapSubscriptionPlans(){
      val plans = repository.getSubscriptionPlans()
      _subscriptionPlans.value = plans.map{
         mapSubscriptionPlan(it)
      }
   }
   fun mapSubscriptionPlan(subscriptionPlan : SubscriptionPlan) : SubscriptionViewData{
      return SubscriptionViewData(
         title = subscriptionPlan.title,
         description = subscriptionPlan.description,
         price = subscriptionPlan.price,
         features = subscriptionPlan.features.map{
            mapFeaturePlan(it)
         }
      ) 
   }
   
   fun mapFeaturePlan(featurePlan : FeaturePlan) : FeatureViewData{
      return FeatureViewData(
         name = featurePlan.nameFeature,
         icon = featurePlan.iconFeature
      )
   }
}