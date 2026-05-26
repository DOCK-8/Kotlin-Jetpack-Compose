package com.example.myapplication.models.repository

import com.example.myapplication.models.data.ProductionCompany

fun getProductionCompany(): ProductionCompany {
    return ProductionCompany(
        id = "1",
        name = "Production Company Name",
    )
}
fun getListProductionCompany() : List<ProductionCompany> {
    return listOf(
        getProductionCompany(),
        getProductionCompany(),
        getProductionCompany(),
    )
}