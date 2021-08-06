package com.picpay.desafio.android.domain.user.usecase

import androidx.lifecycle.LiveData
import com.picpay.desafio.android.data.remote.network.Resource
import com.picpay.desafio.android.domain.user.model.User
import kotlinx.coroutines.CoroutineDispatcher

interface GetUsersUseCase {

    fun execute(dispatcher: CoroutineDispatcher): LiveData<Resource<List<User>>>
}
