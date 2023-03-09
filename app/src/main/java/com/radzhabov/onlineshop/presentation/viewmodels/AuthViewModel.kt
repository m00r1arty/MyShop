package com.radzhabov.onlineshop.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.radzhabov.data.db.UserDao
import com.radzhabov.data.entities.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userDao: UserDao
    ) : ViewModel() {

    suspend fun login(firstName: String): Boolean {
        val user = userDao.login(firstName)
        return user != null
    }

    suspend fun register(firstName: String, lastName: String, email: String) {
        userDao.register(User(firstname = firstName, lastname = lastName, email = email))
    }

}