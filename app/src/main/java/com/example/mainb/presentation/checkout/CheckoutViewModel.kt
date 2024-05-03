package com.example.mainb.presentation.checkout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.mainb.data.repository.CartRepository
import com.example.mainb.data.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CheckoutViewModel(
    private val cartRepository: CartRepository,
    private val productRepository: ProductRepository,
) : ViewModel() {
    val checkoutData = cartRepository.getCheckoutData().asLiveData(Dispatchers.IO)

    fun checkoutCart() =
        productRepository.createOrder(
            checkoutData.value?.payload?.first.orEmpty(),
        ).asLiveData(Dispatchers.IO)

    fun deleteAllCart() {
        viewModelScope.launch {
            cartRepository.deleteAllCart().collect {}
        }
    }
}
