package com.picpay.desafio.android.data.converter

import com.picpay.desafio.android.UserMock
import org.junit.Assert.assertEquals
import org.junit.Test

class UserConverterTest {

    private val sut = UserConverter()

    @Test
    fun givenUserOutput_whenCallConverter_mustReturnUser() {
        val user = sut.toUser(UserMock.mockUserOutputOne)

        assertEquals(UserMock.mockUserOne, user)
    }

    @Test
    fun givenUserOutput_whenCallConverter_mustReturnUserEntity() {
        val userEntity = sut.toUserEntity(UserMock.mockUserOutputOne)

        assertEquals(UserMock.mockUserEntityOne, userEntity)
    }

    @Test
    fun givenUserEntity_whenCallConverter_mustReturnUserOutput() {
        val userOutput = sut.toUserOutput(UserMock.mockUserEntityOne)

        assertEquals(UserMock.mockUserOutputOne, userOutput)
    }

    @Test
    fun givenUserOutputList_whenCallConverter_mustReturnUserList() {
        val userList = sut.toUserList(UserMock.mockUserOutputList())

        assertEquals(UserMock.mockUserList(), userList)
    }

    @Test
    fun givenUserOutputList_whenCallConverter_mustReturnUserEntityList() {
        val userEntityList = sut.toUserEntityList(UserMock.mockUserOutputList())

        assertEquals(UserMock.mockUserEntityList(), userEntityList)
    }

    @Test
    fun givenUserEntityList_whenCallConverter_mustReturnUserOutputList() {
        val userOutputList = sut.toUserOutputList(UserMock.mockUserEntityList())

        assertEquals(UserMock.mockUserOutputList(), userOutputList)
    }
}
