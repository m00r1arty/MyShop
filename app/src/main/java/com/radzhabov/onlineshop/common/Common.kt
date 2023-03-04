package com.radzhabov.onlineshop.common

import com.radzhabov.onlineshop.data.repositories.FlashSaleServices
import com.radzhabov.onlineshop.data.repositories.RetrofitClient

object Common {
    private val BASE_URL = "https://run.mocky.io/v3/"
    val flashSaleService: FlashSaleServices
        get() = RetrofitClient.getClient(BASE_URL).create(FlashSaleServices::class.java)
}