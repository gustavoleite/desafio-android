package com.picpay.desafio.android.domain.user.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.picpay.desafio.android.MainCoroutineRule
import com.picpay.desafio.android.UserMock
import com.picpay.desafio.android.data.converter.UserConverter
import com.picpay.desafio.android.data.local.dao.UserDao
import com.picpay.desafio.android.data.remote.network.Resource
import com.picpay.desafio.android.domain.user.model.User
import com.picpay.desafio.android.domain.user.repository.UserRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.never
import org.mockito.Mockito.times
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class GetUsersUseCaseImplTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Captor
    private lateinit var argumentCaptor: ArgumentCaptor<Resource<List<User>>>

    @Mock
    private lateinit var observer: Observer<Resource<List<User>>>

    @Mock
    private lateinit var localRepository: UserDao

    @Mock
    private lateinit var remoteRepository: UserRepository

    private lateinit var sut: GetUsersUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        sut = GetUsersUseCaseImpl(UserConverter(), localRepository, remoteRepository)
    }

    @Test
    fun givenGetUserWasExecuted_mustReturnLoadingResource() {
        mainCoroutineRule.testDispatcher.runBlockingTest {
            mockCachedData()

            sut.execute(mainCoroutineRule.testDispatcher).observeForever(observer)

            Mockito
                .verify(observer)
                .onChanged(Resource.loading(data = null))
        }
    }

    @Test
    fun givenGetUserWasExecuted_whenHaveCachedData_mustReturnLocalRepositoryData() {
        mainCoroutineRule.testDispatcher.runBlockingTest {
            mockCachedData()

            sut.execute(mainCoroutineRule.testDispatcher).observeForever(observer)

            Mockito
                .verify(localRepository)
                .getAll()

            Mockito
                .verify(remoteRepository, never())
                .getAll()

            assertSuccessDataReturn()
        }
    }

    @Test
    fun givenGetUserWasExecuted_whenThereIsNoCachedData_mustCallRemoteRepository() {
        mainCoroutineRule.testDispatcher.runBlockingTest {
            mockCleanCache()
            mockGetRepositoryDataWithSuccess()

            sut.execute(mainCoroutineRule.testDispatcher).observeForever(observer)

            Mockito
                .verify(localRepository)
                .getAll()

            Mockito
                .verify(remoteRepository)
                .getAll()

            assertSuccessDataReturn()
        }
    }

    @Test(expected = Exception::class)
    fun givenGetUserWasExecuted_whenRemoteRepositoryThrowsException_mustReturnErrorResource() {
        mainCoroutineRule.testDispatcher.runBlockingTest {
            mockCleanCache()
            mockGetRepositoryDataWithError()

            sut.execute(mainCoroutineRule.testDispatcher).observeForever(observer)

            Mockito
                .verify(localRepository)
                .getAll()

            Mockito
                .verify(remoteRepository)
                .getAll()

            Mockito
                .verify(observer, times(2))
                .onChanged(argumentCaptor.capture())

            assertEquals(
                Resource.error(data = null, message = ""),
                argumentCaptor.allValues[1]
            )
        }
    }

    private fun assertSuccessDataReturn() {
        Mockito
            .verify(observer, times(2))
            .onChanged(argumentCaptor.capture())

        assertEquals(
            Resource.success(UserMock.mockUserList()),
            argumentCaptor.allValues[1]
        )
    }

    private suspend fun mockCachedData() {
        Mockito.`when`(localRepository.getAll())
            .thenReturn(UserMock.mockUserEntityList())
    }

    private suspend fun mockCleanCache() {
        Mockito.`when`(localRepository.getAll())
            .thenReturn(emptyList())
    }

    private suspend fun mockGetRepositoryDataWithSuccess() {
        Mockito.`when`(remoteRepository.getAll())
            .thenReturn(UserMock.mockUserOutputList())
    }

    private suspend fun mockGetRepositoryDataWithError() {
        Mockito.`when`(remoteRepository.getAll())
            .thenThrow(Exception())
    }
}
