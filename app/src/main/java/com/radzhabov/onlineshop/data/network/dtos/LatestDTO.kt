package com.radzhabov.onlineshop.data.network.dtos

data class LatestDTO(
    val latest: List<LatestX>
)

data class LatestX(
    val category: String,
    val image_url: String,
    val name: String,
    val price: Int
)