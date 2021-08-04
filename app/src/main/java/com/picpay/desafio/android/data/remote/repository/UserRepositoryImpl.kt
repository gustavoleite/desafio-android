package com.picpay.desafio.android.data.remote.repository

import com.picpay.desafio.android.data.remote.PicPayService
import com.picpay.desafio.android.data.remote.entity.User

class UserRepositoryImpl(private val service: PicPayService) : UserRepository {

    override suspend fun getAll(): List<User> = service.getUsers()
}