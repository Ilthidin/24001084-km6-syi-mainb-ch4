package com.example.mainb.presentation.detailproduct

import android.app.ProgressDialog.show
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import coil.load
import com.example.mainb.R
import com.example.mainb.data.datasource.cart.CartDataSource
import com.example.mainb.data.datasource.cart.CartDatabaseDataSource
import com.example.mainb.data.model.Product
import com.example.mainb.data.repository.CartRepository
import com.example.mainb.data.repository.CartRepositoryImpl
import com.example.mainb.data.source.local.database.AppDatabase
import com.example.mainb.databinding.ActivityDetailProductBinding
import com.example.mainb.utils.GenericViewModelFactory
import com.example.mainb.utils.proceedWhen
import com.example.mainb.utils.toIndonesianFormat

class DetailProductActivity : AppCompatActivity() {
    private val binding: ActivityDetailProductBinding by lazy {
        ActivityDetailProductBinding.inflate(layoutInflater)
    }
    private val viewModel: DetailProductViewModel by viewModels {
        val db = AppDatabase.getInstance(this)
        val ds: CartDataSource = CartDatabaseDataSource(db.cartDao())
        val rp: CartRepository = CartRepositoryImpl(ds)
        GenericViewModelFactory.create(
            DetailProductViewModel(intent?.extras, rp)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        bindProduct(viewModel.product)
        setClickListener()
        observeData()
    }

    private fun setClickListener() {
        binding.ibBack.setOnClickListener {
            onBackPressed()
        }
        binding.ivMinus.setOnClickListener {
            viewModel.minus()
        }
        binding.ivPlus.setOnClickListener {
            viewModel.add()
        }
        binding.btnAddToCart.setOnClickListener {
            addProductToCart()
        }
        binding.tvAddress.setOnClickListener {
            val url = "https://maps.app.goo.gl/UDYq168bTXMJKNpk8"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }

    private fun addProductToCart() {
        viewModel.addToCart().observe(this) {
            it.proceedWhen(
                doOnSuccess = {
                    Toast.makeText(
                        this,
                        getString(R.string.text_add_to_cart_success), Toast.LENGTH_SHORT
                    ).show()
                    finish()
                },
                doOnError = {
                    Toast.makeText(this, getString(R.string.add_to_cart_failed), Toast.LENGTH_SHORT)
                },
                doOnLoading = {
                    Toast.makeText(this, getString(R.string.loading), Toast.LENGTH_SHORT).show()
                }
            )
        }
    }

    private fun bindProduct(product: Product?) {
        product?.let { item ->
            binding.ivCatalogImage.load(item.imgUrl) {
                crossfade(true)
            }
            binding.tvCatalogName.text = item.name
            binding.tvCatalogDesc.text = item.desc
            binding.tvAddress.text = item.address
            binding.tvCatalogPrice.text = item.price.toIndonesianFormat()
        }
    }

    private fun observeData() {
        viewModel.priceLiveData.observe(this) {
            binding.btnAddToCart.isEnabled = it != 0.0
            binding.tvCalculatedCatalogPrice.text = it.toIndonesianFormat()
        }
        viewModel.productCountLiveData.observe(this) {
            binding.tvProductCount.text = it.toString()
        }
    }

    companion object {
        const val EXTRA_PRODUCT = "EXTRA_PRODUCT"
        fun startActivity(context: Context, product: Product) {
            val intent = Intent(context, DetailProductActivity::class.java)
            intent.putExtra(EXTRA_PRODUCT, product)
            context.startActivity(intent)
        }
    }
}