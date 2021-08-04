package com.picpay.desafio.android.network

data class ResourceOld<out T>(
    val status: Status,
    val data: T?,
    val message: String?
) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T?): ResourceOld<T> {
            return ResourceOld(
                Status.SUCCESS,
                data,
                null
            )
        }

        fun <T> error(msg: String, data: T? = null): ResourceOld<T> {
            return ResourceOld(
                Status.ERROR,
                data,
                msg
            )
        }

        fun <T> loading(data: T? = null): ResourceOld<T> {
            return ResourceOld(
                Status.LOADING,
                data,
                null
            )
        }
    }
}
