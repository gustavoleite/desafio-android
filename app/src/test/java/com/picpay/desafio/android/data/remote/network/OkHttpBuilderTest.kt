package com.picpay.desafio.android.data.remote.network

import io.mockk.mockk
import junit.framework.TestCase.assertTrue
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Assert.assertEquals
import org.junit.Test

class OkHttpBuilderTest {

    private val mockInterceptor = mockk<HttpLoggingInterceptor>()
    private val sut = OkHttpBuilder(mockInterceptor)

    @Test
    fun whenBuildOkhttp_mustHaveDefaultConnectTimeout() {
        val instance = sut.build()

        assertEquals(30000, instance.connectTimeoutMillis)
    }

    @Test
    fun whenBuildOkhttp_mustHaveDefaultWriteTimeout() {
        val instance = sut.build()

        assertEquals(30000, instance.writeTimeoutMillis)
    }

    @Test
    fun whenBuildOkhttp_mustHaveDefaultReadTimeout() {
        val instance = sut.build()

        assertEquals(30000, instance.readTimeoutMillis)
    }

    @Test
    fun whenBuildOkhttp_mustHaveHttpLoggingInterceptor() {
        val instance = sut.build()

        assertTrue(instance.interceptors.contains(mockInterceptor))
    }
}
