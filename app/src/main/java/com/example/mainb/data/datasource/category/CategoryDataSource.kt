package com.example.mainb.data.datasource.category

import com.example.mainb.data.model.Category

interface CategoryDataSource {
    fun getCategories(): List<Category>
}