package com.picpay.desafio.android.data.converter

import com.picpay.desafio.android.data.local.dto.UserDTO
import com.picpay.desafio.android.data.remote.entity.User

object UserMock {

    val mockUserOne = User(
        id = 1,
        name = "Carlos Eduardo Souza",
        img = "https://",
        username = "Carlinhos"
    )

    private val mockUserTwo = User(
        id = 2,
        name = "Bruna Lima",
        img = "https://",
        username = "Bru"
    )

    val mockUserDtoOne = UserDTO(
        id = 1,
        name = "Carlos Eduardo Souza",
        img = "https://",
        username = "Carlinhos"
    )

    private val mockUserDtoTwo = UserDTO(
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