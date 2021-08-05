package com.picpay.desafio.android.domain.user.repository

import com.picpay.desafio.android.data.remote.output.UserOutput

interface UserRepository {

    suspend fun getAll(): List<UserOutput>
}
