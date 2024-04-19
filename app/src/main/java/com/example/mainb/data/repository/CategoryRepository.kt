package com.example.mainb.data.repository

import com.example.mainb.data.datasource.category.CategoryDataSource
import com.example.mainb.data.mapper.toCategories
import com.example.mainb.data.model.Category
import com.example.mainb.utils.ResultWrapper
import com.example.mainb.utils.proceedFlow
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    fun getCategories(): Flow<ResultWrapper<List<Category>>>
}

class CategoryRepositoryImpl(
    private val dataSource: CategoryDataSource
) : CategoryRepository {
    override fun getCategories(): Flow<ResultWrapper<List<Category>>> {
        return proceedFlow { dataSource.getCategories().data.toCategories() }
    }
}