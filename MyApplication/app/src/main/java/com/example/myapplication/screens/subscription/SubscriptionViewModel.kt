package com.example.myapplication.screens.subscription

import androidx.lifecycle.ViewModel

import com.example.myapplication.model.Repository
import com.example.myapplication.model.SubscriptionPlan.SubscriptionPlan
import com.example.myapplication.model.SubscriptionPlan.FeaturePlan

class SubscriptionViewModel (
   val repository : Repository,
) : ViewModel {
   private val _subscriptionPlans by mutableStateFlow(List<SubscriptionViewData>)
   val subscriptionPlans = _subscriptionPlans.asStateFlow()

   fun fetchSubscriptionPlans(){
      return repository.getSubscriptionPlans().map(plan ->
         fetchSubscriptionPlan(plan)
      )
   }
   fun fetchSubscriptionPlan(subscriptionPlan : SubscriptionPlan) : SubscriptionViewData{
      return SubscriptionViewData(
         title = subscriptionPlan.title,
         description = subscriptionPlan.description,
         price = subscriptionPlan.price,
         features = subscriptionPlan.map(feature ->
            fetchFeaturePlan(feature)
         )      
      ) 
   }
   
   fun fetchFeaturePlan(featurePlan : FeaturePlan) : FeatureViewData{
      return FeatureViewData(
         name = featurePlan.nameFeature,
         icon = featurePlan.iconFeature
      )
   }
}