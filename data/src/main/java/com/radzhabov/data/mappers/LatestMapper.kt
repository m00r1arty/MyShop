package com.radzhabov.data.mappers

import com.radzhabov.data.model.Latest
import com.radzhabov.data.network.dtos.LatestX

fun LatestX.mapLatest() = Latest(
    category = this.category,
    image_url = this.image_url,
    name = this.name,
    price = this.price
)