package com.radzhabov.data.mappers

import com.radzhabov.data.model.FlashSale
import com.radzhabov.data.network.dtos.FlashSaleX

fun FlashSaleX.mapFlashSale() = FlashSale(
    category = this.category,
    discount = this.discount,
    image_url = this.image_url,
    name = this.name,
    price = this.price
)