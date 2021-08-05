package com.picpay.desafio.android.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.picpay.desafio.android.data.local.dao.UserDao
import com.picpay.desafio.android.data.local.entity.UserEntity

internal const val USER_DB_VERSION = 1

@Database(entities = [UserEntity::class], version = USER_DB_VERSION)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
