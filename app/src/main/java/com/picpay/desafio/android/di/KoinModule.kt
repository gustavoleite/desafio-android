package com.picpay.desafio.android.di

import androidx.room.Room
import com.picpay.desafio.android.data.local.AppDb
import com.picpay.desafio.android.data.remote.PicPayService
import com.picpay.desafio.android.data.remote.repository.UserRepository
import com.picpay.desafio.android.data.remote.repository.UserRepositoryImpl
import com.picpay.desafio.android.data.usecase.GetUsersUseCase
import com.picpay.desafio.android.network.RetrofitBuilder
import com.picpay.desafio.android.ui.contact.ContactViewModel
import com.picpay.desafio.android.ui.contact.UserListAdapter
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val networkModule = module {

    single<PicPayService> {
        RetrofitBuilder.buildRetrofitInstance(
            OkHttpClient.Builder().build()
        ).create(PicPayService::class.java)
    }
}

private val adapterModule = module {
    factory { UserListAdapter() }
}

private val dataModule = module {
    single<UserRepository> { UserRepositoryImpl(service = get()) }
    single { GetUsersUseCase(repository = get(), dao = get()) }
}

private val viewModelModule = module {
    viewModel { ContactViewModel(getUsers = get()) }
}

private val roomModule = module {

    single {
        Room
            .inMemoryDatabaseBuilder(
                androidApplication(),
                AppDb::class.java
            )
            .build()
    }

    single {
        get<AppDb>().userDao()
    }
}

val challengeModule = listOf(
    adapterModule,
    networkModule,
    dataModule,
    roomModule,
    viewModelModule
)
