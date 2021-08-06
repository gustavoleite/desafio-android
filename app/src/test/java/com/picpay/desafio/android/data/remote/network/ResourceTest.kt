package com.picpay.desafio.android.data.remote.network

import com.picpay.desafio.android.UserMock
import org.junit.Assert.assertEquals
import org.junit.Test

class ResourceTest {

    @Test
    fun  givenResourceSuccess_whenGetStatus_mustReturnSuccess() {
        val resource = Resource.success(UserMock.mockUserOne)

        assertEquals(resource.status, Status.SUCCESS)
    }

    @Test
    fun givenResourceLoading_whenGetStatus_mustReturnLoading() {
        val resource = Resource.loading(null)

        assertEquals(resource.status, Status.LOADING)
    }


    @Test
    fun  givenResourceError_whenGetStatus_mustReturnError() {
        val resource = Resource.error<String>(data = null, message = "Erro")

        assertEquals(resource.status, Status.ERROR)
    }
}