package com.example.myapplication.model.SubscriptionPlan

class SubscriptionLocalRepository : SubscriptionRepository{
    override fun getSubscriptionPlans () : List<SubscriptionPlan>{
        val testFeature = FeaturePlan(
            nameFeature = "FEATURE DE PRUEBA",
            iconFeature = 1
        )
        val testPlan = SubscriptionPlan(
            id = 1,
            title = "PLAN DE PRUEBA",
            description = "DESCRIPTION",
            price = 999.999,
            features = listOf(testFeature,testFeature)
        )
        val subscriptionPlans : List<SubscriptionPlan> = listOf(
            testPlan,
            testPlan,
            testPlan,
            testPlan,
            testPlan
        )
        return subscriptionPlans
    }
}