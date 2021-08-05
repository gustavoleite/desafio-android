package com.picpay.desafio.android.domain.user.usecase

import androidx.lifecycle.LiveData
import com.picpay.desafio.android.data.remote.network.Resource
import com.picpay.desafio.android.domain.user.model.User
import kotlinx.coroutines.CoroutineScope

interface GetUsersUseCase {

    fun execute(withScope: CoroutineScope): LiveData<Resource<List<User>>>
}
