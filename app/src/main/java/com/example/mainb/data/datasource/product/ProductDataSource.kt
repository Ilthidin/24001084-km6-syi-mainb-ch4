package com.example.mainb.data.datasource.product

import com.example.mainb.data.source.network.model.checkout.CheckoutRequestPayload
import com.example.mainb.data.source.network.model.checkout.CheckoutResponse
import com.example.mainb.data.source.network.model.products.ProductResponse

interface ProductDataSource {
    suspend fun getProducts(categorySlug: String? = null): ProductResponse
    suspend fun createOrder(payload : CheckoutRequestPayload) : CheckoutResponse
}