package com.picpay.desafio.android.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.picpay.desafio.android.data.local.dto.UserDTO

@Dao
interface UserDao {

    @Insert
    fun saveAll(products: List<UserDTO>)

    @Query("SELECT * FROM user")
    fun getAll(): List<UserDTO>
}
