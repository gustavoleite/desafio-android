package com.picpay.desafio.android.data.local.dao

/*
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class UserDaoTest {

    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    private val sut = Room.inMemoryDatabaseBuilder(
        InstrumentationRegistry.getInstrumentation().targetContext,
        AppDataBase::class.java
    )
        .setTransactionExecutor(testDispatcher.asExecutor())
        .setQueryExecutor(testDispatcher.asExecutor())
        .build()
        .userDao()


    @ExperimentalCoroutinesApi
    @Test
    fun saveAll() = testScope.runBlockingTest {
        val expectedEmptyList = emptyList<List<UserDTO>>()

        assertThat(sut.getAll(), `is`(expectedEmptyList))
    }
}*/
