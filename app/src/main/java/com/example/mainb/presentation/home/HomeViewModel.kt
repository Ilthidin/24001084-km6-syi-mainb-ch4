package com.example.mainb.presentation.home

import androidx.lifecycle.ViewModel
import com.example.mainb.data.repository.CatalogRepository
import com.example.mainb.data.repository.CategoryRepository

class HomeViewModel(
    private val categoryRepository: CategoryRepository,
    private val catalogRepository: CatalogRepository
) : ViewModel() {
    fun getCatalog() = catalogRepository.getCatalogs()
    fun getCategories() = categoryRepository.getCategories()
}