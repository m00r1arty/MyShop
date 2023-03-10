package com.radzhabov.data.mappers

import com.radzhabov.data.model.Product
import com.radzhabov.data.network.dtos.LatestX

fun LatestX.mapLatest() = Product.Latest(
    category = this.category,
    imageUrl = this.image_url,
    name = this.name,
    price = this.price
)