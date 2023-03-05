package com.radzhabov.onlineshop.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.radzhabov.onlineshop.R
import com.radzhabov.onlineshop.data.model.FlashSale
import com.squareup.picasso.Picasso

class FlashSaleAdapter(
    private var flashSaleList: List<FlashSale>
    ): RecyclerView.Adapter<FlashSaleAdapter.FlashSaleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashSaleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.flash_sale_item_layout, parent, false)
        return FlashSaleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FlashSaleViewHolder, position: Int) {
        val listItem = flashSaleList[position]
        holder.bind(listItem)
    }

    override fun getItemCount() = flashSaleList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateFlashSaleList(flashSaleList: List<FlashSale>) {
        this.flashSaleList = flashSaleList
        this.notifyDataSetChanged()
    }

    class FlashSaleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val backgroundImage: ImageView = itemView.findViewById(R.id.flash_sale_image)
        private val addButton: ImageView = itemView.findViewById(R.id.add_button)
        private val favoriteButton: ImageView = itemView.findViewById(R.id.favorite_button_background)
        private val category: TextView = itemView.findViewById(R.id.category_brands)
        private val discount: TextView = itemView.findViewById(R.id.discount)
        private val name: TextView = itemView.findViewById(R.id.name_brands)
        private val price: TextView = itemView.findViewById(R.id.price_view)

        fun bind(flashSale: FlashSale) {
            addButton.setOnClickListener {
                Toast.makeText(it.context, "Успешно добавлен в корзину", Toast.LENGTH_SHORT)
                    .show()
            }
            favoriteButton.setOnClickListener {
                Toast.makeText(it.context, "Добавлено в избранное", Toast.LENGTH_SHORT)
                    .show()
            }
            Picasso.get().load(flashSale.image_url).into(backgroundImage)
            category.text = flashSale.category
            discount.text = flashSale.discount.toString() + "% off"
            name.text = flashSale.name
            price.text =  "$ " + flashSale.price.toString()
        }

    }
}