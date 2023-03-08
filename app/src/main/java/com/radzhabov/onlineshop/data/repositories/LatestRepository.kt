package com.radzhabov.onlineshop.data.repositories

import com.radzhabov.onlineshop.data.mappers.mapLatest
import com.radzhabov.onlineshop.data.model.Latest
import com.radzhabov.onlineshop.data.network.api.LatestApi
import com.radzhabov.onlineshop.data.network.service.NetworkService

class LatestRepository(private val latestApi: LatestApi) {

    suspend fun getLatestList(): List<Latest> {
        val result = NetworkService.handleCall(latestApi.getLatestList())
        return result?.latest?.map { it.mapLatest() } ?: emptyList()
    }

}