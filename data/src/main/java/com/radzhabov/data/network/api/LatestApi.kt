package com.radzhabov.data.network.api

import com.radzhabov.data.network.dtos.FlashSaleDTO
import com.radzhabov.data.network.dtos.LatestDTO
import retrofit2.Call
import retrofit2.http.GET

interface LatestApi {
    @GET("cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    fun getLatestList(): Call<LatestDTO>
}