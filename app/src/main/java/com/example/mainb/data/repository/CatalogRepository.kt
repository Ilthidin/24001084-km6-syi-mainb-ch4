package com.example.mainb.data.repository

import com.example.mainb.data.datasource.catalog.CatalogDataSource
import com.example.mainb.data.model.Catalog

interface CatalogRepository {
    fun getCatalogs(): List<Catalog>
}

class CatalogRepositoryImpl(private val dataSource: CatalogDataSource) : CatalogRepository {
    override fun getCatalogs(): List<Catalog> = dataSource.getCatalogs()
}
