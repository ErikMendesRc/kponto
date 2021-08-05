package com.example.pontop_kabum.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class UserEntity (

    @PrimaryKey(autoGenerate = true) val id: Int,

    @ColumnInfo(name = "userId") val userId: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "lastname") val lastname: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val password: String?


)