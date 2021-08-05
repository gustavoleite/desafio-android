package com.picpay.desafio.android.data.converter

import com.picpay.desafio.android.UserMock
import org.junit.Assert.assertEquals
import org.junit.Test

class UserConverterTest {

    @Test
    fun givenUser_whenCallConverter_mustReturnUserDto() {
        val userConverted = UserConverter.toUserEntity(UserMock.mockUserOne)

        assertEquals(UserMock.mockUserDtoOne, userConverted)
    }

    @Test
    fun givenUserDto_whenCallConverter_mustReturnUser() {
        val userConverted = UserConverter.toUserOutput(UserMock.mockUserDtoOne)

        assertEquals(UserMock.mockUserOne, userConverted)
    }

    @Test
    fun givenUserList_whenCallConverter_mustReturnUserDtoList() {
        val userListConverted = UserConverter.toUserEntityList(UserMock.mockUserList())

        assertEquals(UserMock.mockUserDtoList(), userListConverted)
    }

    @Test
    fun givenUserDtoList_whenCallConverter_mustReturnUserList() {
        val userConverted = UserConverter.toUserOutputList(UserMock.mockUserDtoList())

        assertEquals(UserMock.mockUserList(), userConverted)
    }
}