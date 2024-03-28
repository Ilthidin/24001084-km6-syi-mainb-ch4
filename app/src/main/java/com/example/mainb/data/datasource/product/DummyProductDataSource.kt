package com.example.mainb.data.datasource.product

import com.example.mainb.data.model.Product

class DummyProductDataSource : ProductDataSource {
    override fun getProducts(): List<Product> {
        return listOf(
            Product(
                name = "Nasi Goreng",
                imgUrl = "https://github.com/Ilthidin/food_assets/blob/main/Catalog/img_fried_rice.jpg?raw=true",
                price = 30.0,
                desc = "Nasi yang diberi bumbu dan digoreng bersamaan dengan daging asli",
            ),
            Product(
                name = "Burger",
                imgUrl = "https://github.com/Ilthidin/food_assets/blob/main/Catalog/img_burger.jpg?raw=true",
                price = 30.0,
                desc = "Makanan cepat saji yang terdiri dari roti, daging, sayur, dan berbagai macam isian lainnya",
            ),
            Product(
                name = "Spaghetti",
                imgUrl = "https://github.com/Ilthidin/food_assets/blob/main/Catalog/img_spaghetti.jpg?raw=true",
                price = 30.0,
                desc = "Mie berbentuk pasta asal italia yang memiliki berbagai macam topping dan saus khas italia",
            ),
            Product(
                name = "Bakso",
                imgUrl = "https://github.com/Ilthidin/food_assets/blob/main/Catalog/img_meatball.jpg?raw=true",
                price = 30.0,
                desc = "Daging giling yang berbentuk bola dipadu dengan mie dan daging lain seta ditambahkan dengan kuah kaldu asli",
            ),
            Product(
                name = "Es Teh",
                imgUrl = "https://github.com/Ilthidin/food_assets/blob/main/Catalog/img_ice_tea.jpg?raw=true",
                price = 30.0,
                desc = "Minumal seduhan teh ditambah dengan es memberi rasa segar",
            ),
            Product(
                name = "Salad",
                imgUrl = "https://github.com/Ilthidin/food_assets/blob/main/Catalog/img_salad.jpg?raw=true",
                price = 30.0,
                desc = "Berbagai macam sayuran hijau segar yang dicampur memiliki banyak manfaat bagi kesehatan tubuh",
            ),
            Product(
                name = "Ramen",
                imgUrl = "https://github.com/Ilthidin/food_assets/blob/main/Catalog/img_ramen.jpg?raw=true",
                price = 30.0,
                desc = "Mie asal jepang yang diberikan berbagai macam topping serta kaldu alami sehingga menciptakan rasa yang unik",
            ),
            Product(
                name = "Sushi Roll",
                imgUrl = "https://github.com/Ilthidin/food_assets/blob/main/Catalog/img_sushi.jpg?raw=true",
                price = 30.0,
                desc = "Kombinasi nasi, ikan segar, dan rumput laut membuat sushi roll memiliki rasa yang segar dan kaya di mulut",
            ),
        )
    }
}