package com.picpay.desafio.android.di

import org.junit.Test
import org.koin.dsl.koinApplication
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

class KoinDependenciesTest : KoinTest {

    @Test
    fun mustCheckChallengeModule() {
        koinApplication {
            modules(challengeModule)
        }.checkModules()
    }
}