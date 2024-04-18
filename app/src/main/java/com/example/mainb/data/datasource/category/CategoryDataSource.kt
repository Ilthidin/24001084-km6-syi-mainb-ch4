package com.example.mainb.data.datasource.category

import com.example.mainb.data.source.network.model.category.CategoriesResponse

interface CategoryDataSource {
    suspend fun getCategories(): CategoriesResponse
}