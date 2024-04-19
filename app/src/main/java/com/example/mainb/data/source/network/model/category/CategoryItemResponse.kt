package com.example.mainb.data.source.network.model.category


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class CategoryItemResponse(
    @SerializedName("id")
    val id: String?,
    @SerializedName("image_url")
    val imgUrl: String?,
    @SerializedName("nama")
    val name: String?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("category_desc")
    val categoryDesc: String?,
)