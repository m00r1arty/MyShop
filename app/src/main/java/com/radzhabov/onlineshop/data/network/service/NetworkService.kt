package com.radzhabov.onlineshop.data.network.service

import com.radzhabov.onlineshop.data.network.api.FlashSaleApi
import com.radzhabov.onlineshop.data.network.api.LatestApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class NetworkService private constructor() {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val flashSaleApi: FlashSaleApi
        get() = retrofit.create(FlashSaleApi::class.java)

    val latestApi: LatestApi
        get() = retrofit.create(LatestApi::class.java)

    companion object {

        @Volatile
        private var instance: NetworkService? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: NetworkService().also { instance = it }
            }

        private const val BASE_URL = "https://run.mocky.io/v3/"

        suspend fun <T> handleCall(call: Call<T>): T? = withContext(Dispatchers.Default) {
            return@withContext try {
                val response = call.execute()
                if (response.isSuccessful) {
                    return@withContext response.body()
                } else {
                    throw IllegalArgumentException("Api returns nothing")
                }
            } catch (exception: Exception) {
                exception.printStackTrace()
                null
            }
        }
    }
}