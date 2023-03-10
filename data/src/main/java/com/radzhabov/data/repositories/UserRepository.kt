package com.radzhabov.data.repositories

import com.radzhabov.data.db.UserDao
import com.radzhabov.data.entities.UserEntity
import com.radzhabov.data.mappers.mapUser
import com.radzhabov.data.mappers.mapUserEntity
import com.radzhabov.data.model.User
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val userDao: UserDao) {

    suspend fun login(firstname: String) = withContext(IO) {
        val userEntity = userDao.login(firstname)
        return@withContext userEntity?.mapUser()
    }

    suspend fun register(user: User) = withContext(IO) {
        return@withContext userDao.register(user.mapUserEntity())
    }
}