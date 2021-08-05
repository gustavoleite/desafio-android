package com.picpay.desafio.android.ui.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.data.remote.network.Resource
import com.picpay.desafio.android.domain.user.model.User
import com.picpay.desafio.android.domain.user.usecase.GetUsersUseCase

class ContactViewModel(private val getUsers: GetUsersUseCase) : ViewModel() {

    val users: LiveData<Resource<List<User>>>
        get() = getUsers.execute(withScope = viewModelScope)
}
