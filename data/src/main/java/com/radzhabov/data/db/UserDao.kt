package com.radzhabov.data.db

import androidx.room.*
import com.radzhabov.data.entities.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE firstname = :firstname")
    suspend fun login(firstname: String): User?

    @Insert
    suspend fun register(user: User)
}