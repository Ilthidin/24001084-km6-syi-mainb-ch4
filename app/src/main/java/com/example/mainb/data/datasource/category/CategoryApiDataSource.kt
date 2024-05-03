package com.example.mainb.data.datasource.category

import com.example.mainb.data.source.network.model.category.CategoriesResponse
import com.example.mainb.data.source.network.services.MainBApiService

class CategoryApiDataSource(
    private val service: MainBApiService,
) : CategoryDataSource {
    override suspend fun getCategories(): CategoriesResponse {
        return service.getCategories()
    }
}
