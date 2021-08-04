package com.picpay.desafio.android.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.picpay.desafio.android.data.local.dao.UserDao
import com.picpay.desafio.android.data.local.dto.UserDTO

internal const val USER_DB_VERSION = 1

@Database(entities = [UserDTO::class], version = USER_DB_VERSION)
abstract class AppDb : RoomDatabase() {
    abstract fun userDao(): UserDao
}