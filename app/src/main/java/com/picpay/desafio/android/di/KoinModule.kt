package com.picpay.desafio.android.di

import androidx.room.Room
import com.picpay.desafio.android.BuildConfig
import com.picpay.desafio.android.data.converter.UserConverter
import com.picpay.desafio.android.data.local.db.AppDataBase
import com.picpay.desafio.android.data.local.db.DATABASE
import com.picpay.desafio.android.data.remote.PicPayService
import com.picpay.desafio.android.data.remote.network.NetworkServiceFactory
import com.picpay.desafio.android.data.remote.network.OkHttpBuilder
import com.picpay.desafio.android.data.remote.repository.UserRepositoryImpl
import com.picpay.desafio.android.domain.user.repository.UserRepository
import com.picpay.desafio.android.domain.user.usecase.GetUsersUseCase
import com.picpay.desafio.android.domain.user.usecase.GetUsersUseCaseImpl
import com.picpay.desafio.android.ui.contact.ContactViewModel
import com.picpay.desafio.android.ui.contact.UserListAdapter
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val networkModule = module {

    factory<Interceptor> {
        HttpLoggingInterceptor().also {
            it.level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }
    }

    single { NetworkServiceFactory(OkHttpBuilder(interceptor = get())) }

    single {
        get<NetworkServiceFactory>().provide(PicPayService::class.java)
    }

    factory { UserConverter() }
}

private val adapterModule = module {
    factory { UserListAdapter() }
}

private val dataModule = module {
    single<UserRepository> { UserRepositoryImpl(service = get()) }
    single<GetUsersUseCase> {
        GetUsersUseCaseImpl(
            repository = get(),
            dao = get(),
            converter = get()
        )
    }
}

private val viewModelModule = module {
    viewModel { ContactViewModel(getUsers = get()) }
}

private val roomModule = module {

    single {
        Room
            .databaseBuilder(
                androidApplication(),
                AppDataBase::class.java,
                DATABASE
            )
            .build()
    }

    single {
        get<AppDataBase>().userDao()
    }
}

val challengeModule = listOf(
    adapterModule,
    networkModule,
    dataModule,
    roomModule,
    viewModelModule
)
