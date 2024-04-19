package com.example.mainb.data.repository

import com.example.mainb.data.datasource.product.ProductDataSource
import com.example.mainb.data.mapper.toProducts
import com.example.mainb.data.model.Cart
import com.example.mainb.data.model.Product
import com.example.mainb.data.source.network.model.checkout.CheckoutItemPayload
import com.example.mainb.data.source.network.model.checkout.CheckoutRequestPayload
import com.example.mainb.utils.ResultWrapper
import com.example.mainb.utils.proceedFlow
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProducts(categorySlug: String? = null): Flow<ResultWrapper<List<Product>>>

    fun createOrder(products: List<Cart>): Flow<ResultWrapper<Boolean>>
}

class ProductRepositoryImpl(
    private val dataSource: ProductDataSource
) : ProductRepository {
    override fun getProducts(categorySlug: String?): Flow<ResultWrapper<List<Product>>> {
        return proceedFlow {
            dataSource.getProducts(categorySlug).data.toProducts()
        }
    }

    override fun createOrder(products: List<Cart>): Flow<ResultWrapper<Boolean>> {
        return proceedFlow {
            dataSource.createOrder(CheckoutRequestPayload(
                orders = products.map {
                    CheckoutItemPayload(
                        notes = it.itemNotes,
                        productId = it.productId.orEmpty(),
                        quantity = it.itemQuantity
                    )
                }
            )).status ?: false
        }
    }
}