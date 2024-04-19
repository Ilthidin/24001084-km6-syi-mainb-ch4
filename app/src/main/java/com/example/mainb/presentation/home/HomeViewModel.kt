package com.example.mainb.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.mainb.data.repository.ProductRepository
import com.example.mainb.data.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers

class HomeViewModel(
    private val categoryRepository: CategoryRepository,
    private val productRepository: ProductRepository
) : ViewModel() {
    fun getProducts(categorySlug: String? = null) =
        productRepository.getProducts(categorySlug).asLiveData(Dispatchers.IO)
    fun getCategories() = categoryRepository.getCategories().asLiveData(Dispatchers.IO)
}