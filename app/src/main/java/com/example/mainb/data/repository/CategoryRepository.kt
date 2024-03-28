package com.example.mainb.data.repository

import com.example.mainb.data.datasource.category.CategoryDataSource
import com.example.mainb.data.model.Category

interface CategoryRepository {
    fun getCategories(): List<Category>
}

class CategoryRepositoryImpl(private val dataSource: CategoryDataSource) : CategoryRepository {
    override fun getCategories(): List<Category> = dataSource.getCategories()

}