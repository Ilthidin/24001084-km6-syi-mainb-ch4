package com.example.mainb.data.datasource.catalog

import com.example.mainb.data.model.Catalog

interface CatalogDataSource {
    fun getCatalogs(): List<Catalog>
}