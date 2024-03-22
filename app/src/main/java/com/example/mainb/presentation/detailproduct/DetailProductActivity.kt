package com.example.mainb.presentation.detailproduct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mainb.R
import com.example.mainb.databinding.ActivityCheckoutBinding
import com.example.mainb.databinding.ActivityDetailProductBinding

class DetailProductActivity : AppCompatActivity() {
    private val binding : ActivityDetailProductBinding by lazy {
        ActivityDetailProductBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}