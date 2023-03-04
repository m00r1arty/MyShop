package com.radzhabov.onlineshop.presentation.adapter

import android.content.Context
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
    private val context: Context,
    private val flashSalelist: MutableList<FlashSale>
    ): RecyclerView.Adapter<FlashSaleAdapter.FlashSaleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashSaleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.flash_sale_item_layout, parent, false)
        return FlashSaleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FlashSaleViewHolder, position: Int) {
        val listItem = flashSalelist[position]
        holder.bind(listItem)

        Picasso.get().load(flashSalelist[position].image_url).into(holder.image_background)
        holder.txt_catagory.text = flashSalelist[position].category
        holder.discount.text = flashSalelist[position].discount.toString()
        holder.txt_name.text = flashSalelist[position].name
        holder.txt_price.text = flashSalelist[position].price.toString()
    }

    override fun getItemCount() = flashSalelist.size

    class FlashSaleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image_background: ImageView = itemView.findViewById(R.id.flash_sale_image)
        val image_add_button: ImageView = itemView.findViewById(R.id.add_button)
        val image_favorite_button: ImageView = itemView.findViewById(R.id.favorite_button_background)
        val txt_catagory: TextView = itemView.findViewById(R.id.category_brands)
        val discount: TextView = itemView.findViewById(R.id.discount)
        val txt_name: TextView = itemView.findViewById(R.id.name_brands)
        val txt_price: TextView = itemView.findViewById(R.id.price_view)

        fun bind(flashSale: FlashSale) {
            image_add_button.setOnClickListener {
                Toast. makeText(it.context, "Успешно добавлен в корзину", Toast.LENGTH_SHORT)
                    .show()
            }
            image_favorite_button.setOnClickListener {
                Toast. makeText(it.context, "Добавлено в избранное", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }
}