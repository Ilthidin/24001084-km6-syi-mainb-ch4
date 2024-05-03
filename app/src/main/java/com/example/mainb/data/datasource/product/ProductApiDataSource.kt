package com.example.mainb.data.datasource.product

import com.example.mainb.data.source.network.model.checkout.CheckoutRequestPayload
import com.example.mainb.data.source.network.model.checkout.CheckoutResponse
import com.example.mainb.data.source.network.model.products.ProductResponse
import com.example.mainb.data.source.network.services.MainBApiService

class ProductApiDataSource(
    private val service: MainBApiService,
) : ProductDataSource {
    override suspend fun getProducts(categorySlug: String?): ProductResponse {
        return service.getProducts(categorySlug)
    }

    override suspend fun createOrder(payload: CheckoutRequestPayload): CheckoutResponse {
        return service.createOrder(payload)
    }
}
