package com.example.mainb.data.mapper

import com.example.mainb.data.model.Product
import com.example.mainb.data.source.network.model.products.ProductItemResponse

fun ProductItemResponse?.toProduct() =
    Product(
        name = this?.name.orEmpty(),
        price = this?.price ?: 0.0,
        imgUrl = this?.imgUrl.orEmpty(),
        desc = this?.desc.orEmpty(),
        address = this?.address.orEmpty(),
    )

fun Collection<ProductItemResponse>?.toProducts() =
    this?.map {
        it.toProduct()
    } ?: listOf()
