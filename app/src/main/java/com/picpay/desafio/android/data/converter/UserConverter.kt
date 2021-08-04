package com.picpay.desafio.android.data.converter

import com.picpay.desafio.android.data.local.dto.UserDTO
import com.picpay.desafio.android.data.remote.entity.User

object UserConverter {

    fun toUser(dto: UserDTO) = User(
        id = dto.id,
        img = dto.img,
        name = dto.name,
        username = dto.username
    )

    fun toUserDto(user: User) = UserDTO(
        id = user.id,
        img = user.img,
        name = user.name,
        username = user.username
    )

    fun toUserList(dtoList: List<UserDTO>) = dtoList.map {
        toUser(it)
    }

    fun toUserDtoList(userList: List<User>) = userList.map {
        toUserDto(it)
    }
}
