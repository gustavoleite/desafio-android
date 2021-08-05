package com.picpay.desafio.android.data.local

/*
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class AppDataBaseTest {

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
        val expectedEmptyList = emptyList<List<UserEntity>>()

        MatcherAssert.assertThat(sut.getAll(), CoreMatchers.`is`(expectedEmptyList))
    }
}
*/
