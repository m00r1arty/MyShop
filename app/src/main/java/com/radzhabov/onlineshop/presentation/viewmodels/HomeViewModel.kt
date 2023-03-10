package com.radzhabov.onlineshop.presentation.viewmodels

import androidx.lifecycle.*
import com.radzhabov.data.model.Product
import com.radzhabov.data.repositories.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _flashSale = MutableLiveData<List<Product.FlashSale>>()
    val flashSale: LiveData<List<Product.FlashSale>>
        get() = _flashSale

    private val _latest = MutableLiveData<List<Product.Latest>>()
    val latest: LiveData<List<Product.Latest>>
        get() = _latest

    fun updateRepository() {
        viewModelScope.launch {
            val flashSaleList = productRepository.getFlashSaleList()
            _flashSale.value = flashSaleList

            val latestList = productRepository.getLatestList()
            _latest.value = latestList
        }
    }
}