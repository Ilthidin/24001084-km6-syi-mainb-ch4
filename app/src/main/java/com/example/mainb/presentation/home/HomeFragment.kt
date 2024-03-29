package com.example.mainb.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mainb.data.datasource.category.DummyCategoryDataSource
import com.example.mainb.data.datasource.product.DummyProductDataSource
import com.example.mainb.data.model.Category
import com.example.mainb.data.model.Product
import com.example.mainb.data.repository.CategoryRepository
import com.example.mainb.data.repository.CategoryRepositoryImpl
import com.example.mainb.data.repository.ProductRepository
import com.example.mainb.data.repository.ProductRepositoryImpl
import com.example.mainb.databinding.FragmentHomeBinding
import com.example.mainb.presentation.detailproduct.DetailProductActivity
import com.example.mainb.presentation.home.adapter.CategoryListAdapter
import com.example.mainb.presentation.home.adapter.ProductGridAdapter
import com.example.mainb.presentation.home.adapter.ProductListAdapter
import com.example.mainb.utils.GenericViewModelFactory
import com.example.mainb.utils.GridSpacingItemDecoration

class HomeFragment : Fragment() {

    private lateinit var productListAdapter: ProductListAdapter
    private lateinit var productGridAdapter: ProductGridAdapter
    private lateinit var binding: FragmentHomeBinding
    private var isGrid = true

    private val viewModel: HomeViewModel by viewModels {
        val categoryDataSource = DummyCategoryDataSource()
        val categoryRepository: CategoryRepository = CategoryRepositoryImpl(categoryDataSource)
        val catalogDataSource = DummyProductDataSource()
        val catalogRepository: ProductRepository = ProductRepositoryImpl(catalogDataSource)
        GenericViewModelFactory.create(HomeViewModel(categoryRepository, catalogRepository))
    }

    private val categoryAdapter: CategoryListAdapter by lazy {
        CategoryListAdapter{

        }
    }

    private val productAdapter: ProductListAdapter by lazy {
        ProductListAdapter{
            DetailProductActivity.startActivity(requireContext(), it)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindCategoryList(viewModel.getCategories())
        bindProductList(viewModel.getProduct())
    }

    private fun bindCategoryList(data: List<Category>) {
        binding.rvCategory.apply {
            adapter = categoryAdapter
        }
        categoryAdapter.submitData(data)
    }

    private fun bindProductList(data: List<Product>) {
        val itemDecoration = GridSpacingItemDecoration(2, 12, true)
        binding.rvProduct.apply {
            adapter = productAdapter
            addItemDecoration(itemDecoration)
        }
        productAdapter.submitData(data)
    }

}