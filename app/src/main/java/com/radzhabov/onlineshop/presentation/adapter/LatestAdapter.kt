package com.radzhabov.onlineshop.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.radzhabov.data.model.Product
import com.radzhabov.onlineshop.R
import com.squareup.picasso.Picasso

class LatestAdapter(
    private var latestList: List<Product.Latest>
    ): RecyclerView.Adapter<LatestAdapter.LatestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.latest_item_layout, parent, false)
        return LatestViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LatestViewHolder, position: Int) {
        val listItem = latestList[position]
        holder.bind(listItem)
    }

    override fun getItemCount() = latestList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateLatestList(latestList: List<Product.Latest>) {
        this.latestList = latestList
        this.notifyDataSetChanged()
    }

    class LatestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val backgroundImage: ImageView = itemView.findViewById(R.id.latest_image)
        private val addButton: ImageView = itemView.findViewById(R.id.add_button)
        private val category: TextView = itemView.findViewById(R.id.category)
        private val name: TextView = itemView.findViewById(R.id.name_brand)
        private val price: TextView = itemView.findViewById(R.id.price)

        fun bind(latest: Product.Latest) {
            addButton.setOnClickListener {
                Toast.makeText(it.context, "Успешно добавлен в корзину", Toast.LENGTH_SHORT)
                    .show()
            }
            Picasso.get().load(latest.imageUrl).into(backgroundImage)
            category.text = latest.category
            name.text = latest.name
            price.text = "$ ${latest.price}"
        }
    }
}