package com.picpay.desafio.android

import com.picpay.desafio.android.data.local.entity.UserEntity
import com.picpay.desafio.android.data.remote.output.UserOutput
import com.picpay.desafio.android.domain.user.model.User

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

    val mockUserOutputOne = UserOutput(
        id = 1,
        name = "Carlos Eduardo Souza",
        img = "https://",
        username = "Carlinhos"
    )

    private val mockUserOutputTwo = UserOutput(
        id = 2,
        name = "Bruna Lima",
        img = "https://",
        username = "Bru"
    )

    val mockUserEntityOne = UserEntity(
        id = 1,
        name = "Carlos Eduardo Souza",
        img = "https://",
        username = "Carlinhos"
    )

    private val mockUserEntityTwo = UserEntity(
        id = 2,
        name = "Bruna Lima",
        img = "https://",
        username = "Bru"
    )

    fun mockUserList() = listOf(
        mockUserOne,
        mockUserTwo
    )

    fun mockUserOutputList() = listOf(
        mockUserOutputOne,
        mockUserOutputTwo
    )

    fun mockUserEntityList() = listOf(
        mockUserEntityOne,
        mockUserEntityTwo
    )
}
