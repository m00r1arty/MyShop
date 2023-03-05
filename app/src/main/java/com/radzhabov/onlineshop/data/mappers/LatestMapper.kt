package com.radzhabov.onlineshop.data.mappers

import com.radzhabov.onlineshop.data.model.Latest
import com.radzhabov.onlineshop.data.network.dtos.LatestX

fun LatestX.mapLatest() = Latest(
    category = this.category,
    image_url = this.image_url,
    name = this.name,
    price = this.price
)