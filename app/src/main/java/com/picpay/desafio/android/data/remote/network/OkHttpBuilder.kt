package com.picpay.desafio.android.data.remote.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class OkHttpBuilder(private val interceptor: Interceptor) {

    companion object {
        private const val DEFAULT_TIMEOUT = 30L
    }

    fun build(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }
}
