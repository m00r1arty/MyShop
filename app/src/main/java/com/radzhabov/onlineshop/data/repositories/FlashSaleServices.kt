package com.radzhabov.onlineshop.data.repositories

import com.radzhabov.onlineshop.data.model.FlashSale
import retrofit2.Call
import retrofit2.http.GET

interface FlashSaleServices {
    @GET("a9ceeb6e-416d-4352-bde6-2203416576ac")
    fun getFlashSaleList(): Call<MutableList<FlashSale>>
}