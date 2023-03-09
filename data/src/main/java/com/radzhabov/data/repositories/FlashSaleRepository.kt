package com.radzhabov.data.repositories

import com.radzhabov.data.mappers.mapFlashSale
import com.radzhabov.data.model.FlashSale
import com.radzhabov.data.network.api.FlashSaleApi
import com.radzhabov.data.network.service.NetworkService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FlashSaleRepository @Inject constructor(private val flashSaleApi: FlashSaleApi) {
    suspend fun getFlashSaleList(): List<FlashSale> {
        val result = NetworkService.handleCall(flashSaleApi.getFlashSaleList())
        return result?.flash_sale?.map { it.mapFlashSale() } ?: emptyList()
    }
}