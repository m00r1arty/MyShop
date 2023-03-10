package com.radzhabov.data.repositories

import com.radzhabov.data.mappers.mapFlashSale
import com.radzhabov.data.mappers.mapLatest
import com.radzhabov.data.model.Product
import com.radzhabov.data.network.api.ProductApi
import com.radzhabov.data.network.service.NetworkService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(private val productApi: ProductApi) {
    suspend fun getFlashSaleList(): List<Product.FlashSale> {
        val result = NetworkService.handleCall(productApi.getFlashSaleList())
        return result?.flash_sale?.map { it.mapFlashSale() } ?: emptyList()
    }

    suspend fun getLatestList(): List<Product.Latest> {
        val result = NetworkService.handleCall(productApi.getLatestList())
        return result?.latest?.map { it.mapLatest() } ?: emptyList()
    }
}