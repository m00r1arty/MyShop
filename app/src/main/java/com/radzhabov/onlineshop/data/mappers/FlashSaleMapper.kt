package com.radzhabov.onlineshop.data.mappers

import com.radzhabov.onlineshop.data.model.FlashSale
import com.radzhabov.onlineshop.data.network.dtos.FlashSaleX

fun FlashSaleX.mapFlashSale() = FlashSale(
    category = this.category,
    discount = this.discount,
    image_url = this.image_url,
    name = this.name,
    price = this.price
)