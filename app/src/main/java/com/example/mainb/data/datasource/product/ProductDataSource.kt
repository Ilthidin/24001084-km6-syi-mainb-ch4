package com.example.mainb.data.datasource.product

import com.example.mainb.data.model.Product

interface ProductDataSource {
    fun getProducts(): List<Product>
}