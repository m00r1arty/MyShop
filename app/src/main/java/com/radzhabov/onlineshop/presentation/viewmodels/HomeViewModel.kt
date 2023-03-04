package com.radzhabov.onlineshop.presentation.viewmodels

import androidx.lifecycle.*
import com.radzhabov.onlineshop.data.mappers.mapFlashSale
import com.radzhabov.onlineshop.data.model.FlashSale
import com.radzhabov.onlineshop.data.network.FlashSaleApi
import com.radzhabov.onlineshop.data.network.NetworkService
import kotlinx.coroutines.launch

class HomeViewModel(
    private val flashSaleApi: FlashSaleApi
) : ViewModel() {

    private val _flashSale = MutableLiveData<List<FlashSale>>()
    val flashSale: LiveData<List<FlashSale>>
        get() = _flashSale

    fun updateFlashSale() {
        viewModelScope.launch {
            val result = NetworkService.handleCall(flashSaleApi.getFlashSaleList())
            result?.let { flashSaleList ->
                _flashSale.value = flashSaleList .flash_sale.map { it.mapFlashSale() }
            }
        }
    }

    class Factory(private val flashSaleApi: FlashSaleApi) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            HomeViewModel(flashSaleApi) as T
    }
}