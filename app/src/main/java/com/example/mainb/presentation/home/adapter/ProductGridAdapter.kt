package com.example.mainb.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mainb.data.model.Product
import com.example.mainb.databinding.ItemProductGridBinding
import com.example.mainb.databinding.ItemProductListBinding
import com.example.mainb.utils.toIndonesianFormat

class ProductGridAdapter(private val itemClick: (Product) -> Unit) :
    RecyclerView.Adapter<ProductGridAdapter.ItemProductViewHolder>() {

    private val dataDiffer =
        AsyncListDiffer(
            this,
            object : DiffUtil.ItemCallback<Product>() {
                override fun areItemsTheSame(
                    oldItem: Product,
                    newItem: Product
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: Product,
                    newItem: Product
                ): Boolean {
                    return oldItem == newItem
                }
            }
        )

    fun submitData(data: List<Product>) {
        dataDiffer.submitList(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemProductViewHolder {
        val binding = ItemProductGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemProductViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: ItemProductViewHolder, position: Int) {
        holder.bindView(dataDiffer.currentList[position])
    }

    override fun getItemCount(): Int = dataDiffer.currentList.size

    class ItemProductViewHolder(
        private val binding: ItemProductGridBinding,
        private val itemClick: (Product) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(item: Product) {
            with(item) {
                binding.ivProductImage.load(imgUrl) {
                    crossfade(true)
                }
                binding.tvProductName.text = name
                binding.tvProductPrice.text = price.toIndonesianFormat()
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}