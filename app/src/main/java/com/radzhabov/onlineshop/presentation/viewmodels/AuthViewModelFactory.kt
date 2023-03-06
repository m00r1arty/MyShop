package com.radzhabov.onlineshop.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.radzhabov.onlineshop.data.db.AppDatabase
import com.radzhabov.onlineshop.data.db.UserDao
import com.radzhabov.onlineshop.data.entities.User
import com.radzhabov.onlineshop.data.repositories.FlashSaleRepository
import com.radzhabov.onlineshop.data.repositories.LatestRepository
import kotlinx.coroutines.launch

class AuthViewModelFactory(
    private val userDao: UserDao
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        AuthViewModelFactory(userDao) as T
}
