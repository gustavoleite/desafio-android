package com.picpay.desafio.android.data.local.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserDTO(
    @PrimaryKey
    @ColumnInfo val id: Int,
    @ColumnInfo val img: String,
    @ColumnInfo val name: String,
    @ColumnInfo val username: String
)
