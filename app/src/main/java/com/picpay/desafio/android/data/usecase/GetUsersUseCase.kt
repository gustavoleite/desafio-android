package com.picpay.desafio.android.data.usecase

import androidx.lifecycle.liveData
import com.picpay.desafio.android.data.converter.UserConverter
import com.picpay.desafio.android.data.local.dao.UserDao
import com.picpay.desafio.android.data.remote.repository.UserRepository
import com.picpay.desafio.android.network.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException

class GetUsersUseCase(private val repository: UserRepository, private val dao: UserDao) {

    fun execute(withScope: CoroutineScope) = liveData(withScope.coroutineContext + Dispatchers.IO) {
        emit(Resource.loading(data = null))

        try {
            val localData = dao.getAll()

            emit(
                if (localData.isEmpty()) {
                    repository.getAllUsers().run {
                        dao.saveAll(UserConverter.toUserDtoList(this))
                        Resource.success(this)
                    }
                } else {
                    Resource.success(UserConverter.toUserList(localData))
                }
            )
        } catch (exception: HttpException) {
            emit(Resource.error(data = null, message = exception.message.orEmpty()))
        }
    }
}