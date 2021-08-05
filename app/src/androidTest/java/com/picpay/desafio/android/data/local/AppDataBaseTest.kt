package com.picpay.desafio.android.data.local

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.picpay.desafio.android.data.local.entity.UserEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.asExecutor
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class UserDaoTest {

    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    private val sut = Room.inMemoryDatabaseBuilder(
        InstrumentationRegistry.getInstrumentation().targetContext,
        AppDataBase::class.java
    )
        .setTransactionExecutor(testDispatcher.asExecutor())
        .setQueryExecutor(testDispatcher.asExecutor())
        .build()
        .userDao()


    @ExperimentalCoroutinesApi
    @Test
    fun saveAll() = testScope.runBlockingTest {
        val expectedEmptyList = emptyList<List<UserEntity>>()

        MatcherAssert.assertThat(sut.getAll(), CoreMatchers.`is`(expectedEmptyList))
    }
}