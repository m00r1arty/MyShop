package com.radzhabov.onlineshop.presentation.viewmodels

import androidx.lifecycle.*
import com.radzhabov.onlineshop.data.mappers.mapFlashSale
import com.radzhabov.onlineshop.data.model.FlashSale
import com.radzhabov.onlineshop.data.network.FlashSaleApi
import com.radzhabov.onlineshop.data.network.NetworkService
import com.radzhabov.onlineshop.data.repositories.FlashSaleRepository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val flashSaleRepository: FlashSaleRepository
) : ViewModel() {

    private val _flashSale = MutableLiveData<List<FlashSale>>()
    val flashSale: LiveData<List<FlashSale>>
        get() = _flashSale

    fun updateFlashSale() {
        viewModelScope.launch {
            val flashSaleList = flashSaleRepository.getFlashSaleList()
            _flashSale.value = flashSaleList
        }
    }

    class Factory(private val flashSaleRepository: FlashSaleRepository) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            HomeViewModel(flashSaleRepository) as T
    }
}