package com.picpay.desafio.android.data.remote.repository

import com.picpay.desafio.android.data.remote.PicPayService
import com.picpay.desafio.android.data.remote.output.UserOutput
import com.picpay.desafio.android.domain.user.repository.UserRepository

class UserRepositoryImpl(private val service: PicPayService) : UserRepository {

    override suspend fun getAll(): List<UserOutput> = service.getUsers()
}
