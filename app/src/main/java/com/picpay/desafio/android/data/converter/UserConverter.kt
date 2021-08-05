package com.picpay.desafio.android.data.converter

import com.picpay.desafio.android.data.local.entity.UserEntity
import com.picpay.desafio.android.data.remote.output.UserOutput
import com.picpay.desafio.android.domain.user.model.User

class UserConverter {

    fun toUser(output: UserOutput) = User(
        id = output.id,
        img = output.img,
        name = output.name,
        username = output.username
    )

    fun toUserOutput(entity: UserEntity) = UserOutput(
        id = entity.id,
        img = entity.img,
        name = entity.name,
        username = entity.username
    )

    fun toUserEntity(output: UserOutput) = UserEntity(
        id = output.id,
        img = output.img,
        name = output.name,
        username = output.username
    )

    fun toUserList(outputList: List<UserOutput>) = outputList.map {
        toUser(it)
    }

    fun toUserOutputList(entityList: List<UserEntity>) = entityList.map {
        toUserOutput(it)
    }

    fun toUserEntityList(outputList: List<UserOutput>) = outputList.map {
        toUserEntity(it)
    }
}
