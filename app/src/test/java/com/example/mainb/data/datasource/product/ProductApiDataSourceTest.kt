package com.example.mainb.data.datasource.product

import com.example.mainb.data.source.network.model.checkout.CheckoutRequestPayload
import com.example.mainb.data.source.network.model.checkout.CheckoutResponse
import com.example.mainb.data.source.network.model.products.ProductResponse
import com.example.mainb.data.source.network.services.MainBApiService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class ProductApiDataSourceTest {
    @MockK
    lateinit var service: MainBApiService

    private lateinit var ds: ProductDataSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        ds = ProductApiDataSource(service)
    }

    @Test
    fun getProducts() {
        runTest {
            val mockResponse = mockk<ProductResponse>(relaxed = true)
            coEvery { service.getProducts(any()) } returns mockResponse
            val actualResponse = ds.getProducts("Makanan")
            coVerify { service.getProducts(any()) }
            assertEquals(actualResponse, mockResponse)
        }
    }

    @Test
    fun createOrder() {
        runTest {
            val mockRequest = mockk<CheckoutRequestPayload>(relaxed = true)
            val mockResponse = mockk<CheckoutResponse>(relaxed = true)
            coEvery { service.createOrder(any()) } returns mockResponse
            val actualResponse = ds.createOrder(mockRequest)
            coVerify { service.createOrder(any()) }
            assertEquals(actualResponse, mockResponse)
        }
    }
}