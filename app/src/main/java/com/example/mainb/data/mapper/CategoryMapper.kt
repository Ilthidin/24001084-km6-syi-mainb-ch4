package com.example.mainb.data.mapper

import com.example.mainb.data.model.Category
import com.example.mainb.data.source.network.model.category.CategoryItemResponse

fun CategoryItemResponse?.toCategory() =
    Category(
        id = this?.id.orEmpty(),
        name = this?.name.orEmpty(),
        imgUrl = this?.imgUrl.orEmpty(),
        slug = this?.slug.orEmpty(),
        categoryDesc = "",
    )

fun Collection<CategoryItemResponse>?.toCategories() = this?.map { it.toCategory() } ?: listOf()
