package com.example.mainb.presentation.home

import androidx.lifecycle.ViewModel
import com.example.mainb.data.repository.ProductRepository
import com.example.mainb.data.repository.CategoryRepository

class HomeViewModel(
    private val categoryRepository: CategoryRepository,
    private val catalogRepository: ProductRepository
) : ViewModel() {
    fun getCatalog() = catalogRepository.getProducts()
    fun getCategories() = categoryRepository.getCategories()
}