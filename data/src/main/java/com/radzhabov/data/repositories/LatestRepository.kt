package com.radzhabov.data.repositories

import com.radzhabov.data.mappers.mapLatest
import com.radzhabov.data.model.Latest
import com.radzhabov.data.network.api.LatestApi
import com.radzhabov.data.network.service.NetworkService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LatestRepository @Inject constructor(private val latestApi: LatestApi) {

    suspend fun getLatestList(): List<Latest> {
        val result = NetworkService.handleCall(latestApi.getLatestList())
        return result?.latest?.map { it.mapLatest() } ?: emptyList()
    }

}