package com.picpay.desafio.android.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.picpay.desafio.android.data.local.entity.UserEntity

@Dao
interface UserDao {

    @Insert
    suspend fun saveAll(products: List<UserEntity>)

    @Query("SELECT * FROM user")
    suspend fun getAll(): List<UserEntity>
}
