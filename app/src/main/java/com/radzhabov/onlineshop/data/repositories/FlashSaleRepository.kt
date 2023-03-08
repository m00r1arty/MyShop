package com.radzhabov.onlineshop.data.repositories

import com.radzhabov.onlineshop.data.mappers.mapFlashSale
import com.radzhabov.onlineshop.data.model.FlashSale
import com.radzhabov.onlineshop.data.network.api.FlashSaleApi
import com.radzhabov.onlineshop.data.network.service.NetworkService

class FlashSaleRepository(private val flashSaleApi: FlashSaleApi) {
    suspend fun getFlashSaleList(): List<FlashSale> {
        val result = NetworkService.handleCall(flashSaleApi.getFlashSaleList())
        return result?.flash_sale?.map { it.mapFlashSale() } ?: emptyList()
    }
}