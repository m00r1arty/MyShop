package com.radzhabov.onlineshop.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.radzhabov.onlineshop.data.db.UserDao
import com.radzhabov.onlineshop.data.entities.User

class AuthViewModel(
    private val userDao: UserDao
    ) : ViewModel() {

    suspend fun login(firstName: String): Boolean {
        val user = userDao.login(firstName)
        return user != null
    }

    suspend fun register(firstName: String, lastName: String, email: String) {
        userDao.register(User(firstname = firstName, lastname = lastName, email = email))
    }

    class Factory(
        private val userDao: UserDao
    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            AuthViewModel(userDao) as T
    }
}