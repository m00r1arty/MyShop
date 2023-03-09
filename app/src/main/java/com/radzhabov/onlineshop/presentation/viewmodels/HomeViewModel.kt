package com.radzhabov.onlineshop.presentation.viewmodels

import androidx.lifecycle.*
import com.radzhabov.data.model.FlashSale
import com.radzhabov.data.model.Latest
import com.radzhabov.data.repositories.FlashSaleRepository
import com.radzhabov.data.repositories.LatestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val flashSaleRepository: FlashSaleRepository,
    private val latestRepository: LatestRepository
) : ViewModel() {

    private val _flashSale = MutableLiveData<List<FlashSale>>()
    val flashSale: LiveData<List<FlashSale>>
        get() = _flashSale

    private val _latest = MutableLiveData<List<Latest>>()
    val latest: LiveData<List<Latest>>
        get() = _latest

    fun updateRepository() {
        viewModelScope.launch {
            val flashSaleList = flashSaleRepository.getFlashSaleList()
            _flashSale.value = flashSaleList

            val latestList = latestRepository.getLatestList()
            _latest.value = latestList
        }
    }
}