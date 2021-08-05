package com.picpay.desafio.android.data.remote.repository

import com.picpay.desafio.android.UserMock
import com.picpay.desafio.android.data.remote.PicPayService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class UserRepositoryImplTest {

    private val mockService = mockk<PicPayService> {
        coEvery { getUsers() } returns UserMock.mockUserList()
    }
    private val sut = UserRepositoryImpl(mockService)

    @ExperimentalCoroutinesApi
    @Test
    fun whenGetAllUsers_mustReturnUserListFromService() {
        runBlockingTest {
            sut.getAll()
        }

        coVerify {
            mockService.getUsers()
        }
    }
}