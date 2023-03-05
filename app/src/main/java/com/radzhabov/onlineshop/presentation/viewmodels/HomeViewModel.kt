package com.radzhabov.onlineshop.presentation.viewmodels

import androidx.lifecycle.*
import com.radzhabov.onlineshop.data.model.FlashSale
import com.radzhabov.onlineshop.data.model.Latest
import com.radzhabov.onlineshop.data.repositories.FlashSaleRepository
import com.radzhabov.onlineshop.data.repositories.LatestRepository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val flashSaleRepository: FlashSaleRepository,
    private val latestRepository: LatestRepository
) : ViewModel() {

    private val _flashSale = MutableLiveData<List<FlashSale>>()
    val flashSale: LiveData<List<FlashSale>>
        get() = _flashSale

    private val _latest = MutableLiveData<List<Latest>>()
    val latest: LiveData<List<Latest>>
        get() = _latest

    fun updateFlashSale() {
        viewModelScope.launch {
            val flashSaleList = flashSaleRepository.getFlashSaleList()
            _flashSale.value = flashSaleList

            val latestList = latestRepository.getLatestList()
            _latest.value = latestList
        }
    }

    class Factory(
        private val flashSaleRepository: FlashSaleRepository,
        private val latestRepository: LatestRepository
        ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            HomeViewModel(flashSaleRepository, latestRepository) as T
    }
}