package com.picpay.desafio.android.data.remote.repository

import com.picpay.desafio.android.data.remote.entity.User

interface UserRepository {

    suspend fun getAllUsers(): List<User>
}
