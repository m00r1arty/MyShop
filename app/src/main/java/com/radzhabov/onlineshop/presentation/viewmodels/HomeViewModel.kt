package com.radzhabov.onlineshop.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radzhabov.onlineshop.data.model.FlashSale
import com.radzhabov.onlineshop.data.repositories.FlashSaleServices

class HomeViewModel(
    private val repository: FlashSaleServices
) : ViewModel() {

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is home Fragment"
//    }
//    val text: LiveData<String> = _text

    private val _flashSale = MutableLiveData<FlashSale>()
    val flashSale: LiveData<List<FlashSale>>
        get() = _flashSale

    suspend fun getFlashSale() {
        val flashSale = repository.getFlashSaleList()
        _flashSale.value = flashSale
    }
}