package com.picpay.desafio.android.data.usecase

import androidx.lifecycle.liveData
import com.picpay.desafio.android.data.converter.UserConverter
import com.picpay.desafio.android.data.local.dao.UserDao
import com.picpay.desafio.android.data.remote.entity.User
import com.picpay.desafio.android.data.remote.repository.UserRepository
import com.picpay.desafio.android.network.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class GetUsersUseCase(private val repository: UserRepository, private val dao: UserDao) {

    fun execute(withScope: CoroutineScope) = liveData(withScope.coroutineContext + Dispatchers.IO) {
        emit(Resource.loading(data = null))

        try {
            val localData = dao.getAll()

            emit(
                if (localData.isEmpty()) {
                    repository.getAll().run {
                        dao.saveAll(UserConverter.toUserDtoList(this))
                        Resource.success(this)
                    }
                } else {
                    Resource.success(UserConverter.toUserList(localData))
                }
            )

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message.orEmpty()))
        }
    }

}