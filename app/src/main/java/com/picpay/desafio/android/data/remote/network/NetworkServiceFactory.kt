package com.picpay.desafio.android.data.remote.network

class NetworkServiceFactory(private val okHttpBuilder: OkHttpBuilder) {

    fun <T> provide(clazz: Class<T>): T {
        return RetrofitBuilder(okHttpBuilder.build())
            .build()
            .create(clazz)
    }
}
