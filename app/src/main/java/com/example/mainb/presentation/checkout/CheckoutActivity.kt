package com.example.mainb.presentation.checkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mainb.R
import com.example.mainb.databinding.ActivityCheckoutBinding

class CheckoutActivity : AppCompatActivity() {

    private val binding : ActivityCheckoutBinding by lazy {
        ActivityCheckoutBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}