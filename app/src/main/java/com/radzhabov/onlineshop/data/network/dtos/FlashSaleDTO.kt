package com.radzhabov.onlineshop.data.network.dtos

data class FlashSaleDTO(
    val flash_sale: List<FlashSaleX>
)

data class FlashSaleX(
    val category: String,
    val discount: Int,
    val image_url: String,
    val name: String,
    val price: Double
)