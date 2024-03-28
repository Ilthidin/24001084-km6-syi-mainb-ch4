package com.example.mainb.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mainb.data.datasource.category.DummyCategoryDataSource
import com.example.mainb.data.datasource.product.DummyProductDataSource
import com.example.mainb.data.repository.CategoryRepository
import com.example.mainb.data.repository.CategoryRepositoryImpl
import com.example.mainb.data.repository.ProductRepository
import com.example.mainb.data.repository.ProductRepositoryImpl
import com.example.mainb.databinding.FragmentHomeBinding
import com.example.mainb.utils.GenericViewModelFactory

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels {
        val categoryDataSource = DummyCategoryDataSource()
        val categoryRepository: CategoryRepository = CategoryRepositoryImpl(categoryDataSource)
        val catalogDataSource = DummyProductDataSource()
        val catalogRepository: ProductRepository = ProductRepositoryImpl(catalogDataSource)
        GenericViewModelFactory.create(HomeViewModel(categoryRepository, catalogRepository))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

//    private fun bindCategiryList(data : List<Category>){
//        binding.rvCategory.apply {
//            adapter = categoryAdapter
//        }
//        categoryAdapter.submitData(data)
//    }
}