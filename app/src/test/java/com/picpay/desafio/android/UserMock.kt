package com.picpay.desafio.android

import com.picpay.desafio.android.data.local.entity.UserEntity
import com.picpay.desafio.android.data.remote.output.UserOutput

object UserMock {

    val mockUserOne = UserOutput(
        id = 1,
        name = "Carlos Eduardo Souza",
        img = "https://",
        username = "Carlinhos"
    )

    private val mockUserTwo = UserOutput(
        id = 2,
        name = "Bruna Lima",
        img = "https://",
        username = "Bru"
    )

    val mockUserDtoOne = UserEntity(
        id = 1,
        name = "Carlos Eduardo Souza",
        img = "https://",
        username = "Carlinhos"
    )

    private val mockUserDtoTwo = UserEntity(
        id = 2,
        name = "Bruna Lima",
        img = "https://",
        username = "Bru"
    )

    fun mockUserList() = listOf(
        mockUserOne,
        mockUserTwo
    )

    fun mockUserDtoList() = listOf(
        mockUserDtoOne,
        mockUserDtoTwo
    )
}