package com.picpay.desafio.android.data.remote.network

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import okhttp3.OkHttpClient
import org.junit.Test

class NetworkServiceFactoryTest {

    @Test
    fun givenOkHttpBuilder_shouldCreateInstance() {
        val okhttpBuilder = mockk<OkHttpBuilder> {
            every { build() } returns OkHttpClient()
        }

        val networkServiceFactory = NetworkServiceFactory(okhttpBuilder)

        networkServiceFactory.provide(MockApi::class.java)

        verify {
            okhttpBuilder.build()
        }
    }
}

interface MockApi
