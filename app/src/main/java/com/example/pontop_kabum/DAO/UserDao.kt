package com.example.pontop_kabum.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pontop_kabum.Model.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM users WHERE id IN (userId)")
    fun loadUserById(): UserEntity
}