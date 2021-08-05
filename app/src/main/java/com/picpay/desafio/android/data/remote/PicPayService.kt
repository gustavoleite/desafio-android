package com.picpay.desafio.android.data.remote

import com.picpay.desafio.android.data.remote.output.UserOutput
import retrofit2.http.GET

interface PicPayService {

    @GET("users")
    suspend fun getUsers(): List<UserOutput>
}
