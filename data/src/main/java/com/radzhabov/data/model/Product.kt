package com.radzhabov.data.model

abstract class Product() {
    abstract val category: String
    abstract val imageUrl: String
    abstract val name: String
    abstract val price: Double

    data class FlashSale(
        val discount: Int,
        override val category: String,
        override val imageUrl: String,
        override val name: String,
        override val price: Double,
    ) : Product()

    data class Latest(
        override val category: String,
        override val imageUrl: String,
        override val name: String,
        override val price: Double,
    ) : Product()
}
