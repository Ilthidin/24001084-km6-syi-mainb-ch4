package com.example.mainb.presentation.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mainb.data.repository.CategoryRepository
import com.example.mainb.data.repository.ProductRepository
import com.example.mainb.data.repository.UserRepository
import com.example.mainb.tools.MainCoroutineRule
import com.example.mainb.tools.getOrAwaitValue
import com.example.mainb.utils.ResultWrapper
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class HomeViewModelTest {

    @get:Rule
    val testRule: TestRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineRule: TestRule = MainCoroutineRule(UnconfinedTestDispatcher())

    @MockK
    lateinit var categoryRepository: CategoryRepository

    @MockK
    lateinit var productRepository: ProductRepository

    @MockK
    lateinit var userRepository: UserRepository

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = spyk(
            HomeViewModel(
                categoryRepository,
                productRepository,
            )
        )
    }

    @Test
    fun getProducts() {
        every { productRepository.getProducts(any()) } returns
                flow {
                    emit(ResultWrapper.Success(listOf(mockk(), mockk())))
                }
        val result = viewModel.getProducts().getOrAwaitValue()
        assertEquals(2, result.payload?.size)
        verify { productRepository.getProducts() }
    }


    @Test
    fun getCategories() {
        every { categoryRepository.getCategories() } returns
                flow {
                    emit(ResultWrapper.Success(listOf(mockk(), mockk())))
                }
        val result = viewModel.getCategories().getOrAwaitValue()
        assertEquals(2, result.payload?.size)
        verify { categoryRepository.getCategories() }
    }
}