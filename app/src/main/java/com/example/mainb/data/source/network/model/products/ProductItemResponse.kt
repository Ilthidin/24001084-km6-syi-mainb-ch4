package com.example.mainb.data.source.network.model.products


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ProductItemResponse(
    @SerializedName("alamat_resto")
    val alamatResto: String?,
    @SerializedName("detail")
    val detail: String?,
    @SerializedName("harga")
    val harga: Int?,
    @SerializedName("harga_format")
    val hargaFormat: String?,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("nama")
    val nama: String?
)