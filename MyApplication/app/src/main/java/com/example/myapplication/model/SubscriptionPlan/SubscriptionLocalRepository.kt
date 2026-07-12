package com.example.myapplication.model.SubscriptionPlan

class SubscriptionLocalRepository : SubscriptionRepository{
    override fun getSubscriptionPlans () : List<SubscriptionPlan>{
        val testFeature1 = FeaturePlan(
            nameFeature = "FEATURE DE PRUEBA",
            iconFeature = 1
        )
        val testFeature2 = FeaturePlan(
            nameFeature = "FEATURE DE PRUEBA",
            iconFeature = 2
        )
        val testFeature3 = FeaturePlan(
            nameFeature = "FEATURE DE PRUEBA",
            iconFeature = 3
        )
        val testPlan1 = SubscriptionPlan(
            id = 1,
            plan = 1,
            title = "PLAN DE PRUEBA",
            description = "DESCRIPTION",
            price = 999.999,
            features = listOf(testFeature1,testFeature2,testFeature3)
        )
        val testPlan2 = SubscriptionPlan(
            id = 2,
            plan = 2,
            title = "PLAN DE PRUEBA",
            description = "DESCRIPTION",
            price = 999.999,
            features = listOf(testFeature1,testFeature2,testFeature3)
        )
        val testPlan3 = SubscriptionPlan(
            id = 3,
            plan = 3,
            title = "PLAN DE PRUEBA",
            description = "DESCRIPTION",
            price = 999.999,
            features = listOf(testFeature1,testFeature2,testFeature3)
        )
        val subscriptionPlans : List<SubscriptionPlan> = listOf(
            testPlan1,
            testPlan2,
            testPlan3
        )
        return subscriptionPlans
    }
}