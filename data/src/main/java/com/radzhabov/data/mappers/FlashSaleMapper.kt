package com.radzhabov.data.mappers

import com.radzhabov.data.model.Product
import com.radzhabov.data.network.dtos.FlashSaleX

fun FlashSaleX.mapFlashSale() = Product.FlashSale(
    category = this.category,
    discount = this.discount,
    imageUrl = this.image_url,
    name = this.name,
    price = this.price
)