package com.example.mainb.data.repository

import com.example.mainb.data.datasource.product.ProductDataSource
import com.example.mainb.data.model.Product

interface ProductRepository {
    fun getProducts(): List<Product>
}

class ProductRepositoryImpl(private val dataSource: ProductDataSource) : ProductRepository {
    override fun getProducts(): List<Product> = dataSource.getProducts()
}
