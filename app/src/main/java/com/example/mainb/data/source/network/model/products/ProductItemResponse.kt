package com.example.mainb.data.source.network.model.products


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ProductItemResponse(
    @SerializedName("alamat_resto")
    val address: String?,
    @SerializedName("detail")
    val desc: String?,
    @SerializedName("harga")
    val price: Double?,
    @SerializedName("harga_format")
    val priceFormat: String?,
    @SerializedName("image_url")
    val imgUrl: String?,
    @SerializedName("nama")
    val name: String?
)