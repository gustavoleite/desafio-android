package com.picpay.desafio.android.ui.contact

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.picpay.desafio.android.MainCoroutineRule
import com.picpay.desafio.android.domain.user.usecase.GetUsersUseCase
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ContactViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val mockUseCase = mockk<GetUsersUseCase>(relaxed = true)
    private val sut = ContactViewModel(mockUseCase)

    @Test
    fun whenGetUser_mustCallUseCase() {
        sut.loadUserList()

        verify {
            mockUseCase.execute(any())
        }
    }
}