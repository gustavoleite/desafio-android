package com.picpay.desafio.android.data.local.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnit4
import com.picpay.desafio.android.data.local.dao.UserDao
import com.picpay.desafio.android.data.local.entity.UserEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class AppDataBaseTest {

    private lateinit var userDao: UserDao
    private lateinit var db: AppDataBase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDataBase::class.java
        ).build()
        userDao = db.userDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @ExperimentalCoroutinesApi
    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
        runBlocking {
            val users = mockUserList()

            userDao.saveAll(users)

            assertEquals(users, userDao.getAll())
        }
    }

    private fun mockUserList() = listOf(
        UserEntity(
            id = 1,
            name = "Carlos Eduardo Souza",
            img = "https://",
            username = "Carlinhos"
        ),
        UserEntity(
            id = 2,
            name = "Bruna Lima",
            img = "https://",
            username = "Bru"
        )
    )
}
