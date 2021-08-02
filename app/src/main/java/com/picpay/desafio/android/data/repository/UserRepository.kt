package com.picpay.desafio.android.data.repository

import com.picpay.desafio.android.data.remote.entity.User

interface UserRepository {

    suspend fun getAll(): List<User>
}