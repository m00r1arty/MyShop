package com.radzhabov.data.db

import androidx.room.*
import com.radzhabov.data.entities.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE firstname = :firstname")
    suspend fun login(firstname: String): UserEntity?

    @Insert
    suspend fun register(userEntity: UserEntity)
}