package com.picpay.desafio.android.domain.user.usecase

import androidx.lifecycle.liveData
import com.picpay.desafio.android.data.converter.UserConverter
import com.picpay.desafio.android.data.local.dao.UserDao
import com.picpay.desafio.android.data.remote.network.Resource
import com.picpay.desafio.android.domain.user.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException

class GetUsersUseCaseImpl(
    private val converter: UserConverter,
    private val dao: UserDao,
    private val repository: UserRepository
) : GetUsersUseCase {

    override fun execute(withScope: CoroutineScope) =
        liveData(withScope.coroutineContext + Dispatchers.IO) {
            emit(Resource.loading(data = null))

            try {
                val localData = dao.getAll()

                emit(
                    if (localData.isEmpty()) {
                        repository.getAll().run {
                            dao.saveAll(converter.toUserEntityList(this))
                            Resource.success(converter.toUserList(this))
                        }
                    } else {
                        Resource.success(
                            converter.toUserList(
                                converter.toUserOutputList(
                                    localData
                                )
                            )
                        )
                    }
                )
            } catch (exception: HttpException) {
                emit(Resource.error(data = null, message = exception.message.orEmpty()))
            }
        }
}
