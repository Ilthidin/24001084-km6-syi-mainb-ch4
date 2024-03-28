package com.example.mainb.data.datasource.category

import com.example.mainb.data.model.Category

class DummyCategoryDataSource : CategoryDataSource {
    override fun getCategories(): List<Category> {
        return listOf(
            Category(
                name = "Rice", imgUrl = "https://raw.githubusercontent.com/Ilthidin/food_assets/main/Category/img_rice.webp"
            ),Category(
                name = "Noodle", imgUrl = "https://raw.githubusercontent.com/Ilthidin/food_assets/main/Category/img_noodle.webp"
            ),Category(
                name = "Junk Food", imgUrl = "https://github.com/Ilthidin/food_assets/blob/main/Category/img_juck_food.jpg?raw=true"
            ),Category(
                name = "Snack", imgUrl = "https://github.com/Ilthidin/food_assets/blob/main/Category/img_snack.jpeg?raw=true"
            ),Category(
                name = "Salad", imgUrl = "https://github.com/Ilthidin/food_assets/blob/main/Category/img_salad.jpg?raw=true"
            ),Category(
                name = "Beverage", imgUrl = "https://raw.githubusercontent.com/Ilthidin/food_assets/main/Category/img_beverage.webp"
            ),
        )
    }
}