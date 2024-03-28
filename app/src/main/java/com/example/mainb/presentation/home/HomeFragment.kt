package com.example.mainb.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.mainb.R
import com.example.mainb.data.datasource.catalog.DummyCatalogDataSource
import com.example.mainb.data.datasource.category.DummyCategoryDataSource
import com.example.mainb.data.repository.CatalogRepository
import com.example.mainb.data.repository.CatalogRepositoryImpl
import com.example.mainb.data.repository.CategoryRepository
import com.example.mainb.data.repository.CategoryRepositoryImpl
import com.example.mainb.databinding.FragmentCartBinding
import com.example.mainb.databinding.FragmentHomeBinding
import com.example.mainb.utils.GenericViewModelFactory
import java.util.Locale.Category

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels {
        val categoryDataSource = DummyCategoryDataSource()
        val categoryRepository: CategoryRepository = CategoryRepositoryImpl(categoryDataSource)
        val catalogDataSource = DummyCatalogDataSource()
        val catalogRepository: CatalogRepository = CatalogRepositoryImpl(catalogDataSource)
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
        Toast.makeText(requireContext(), "${viewModel.getCategories().size}", Toast.LENGTH_SHORT).show()
    }

//    private fun bindCategiryList(data : List<Category>){
//        binding.rvCategory.apply {
//            adapter = categoryAdapter
//        }
//        categoryAdapter.submitData(data)
//    }
}