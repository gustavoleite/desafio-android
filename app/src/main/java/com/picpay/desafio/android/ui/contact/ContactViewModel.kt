package com.picpay.desafio.android.ui.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.data.remote.entity.User
import com.picpay.desafio.android.data.usecase.GetUsersUseCase
import com.picpay.desafio.android.network.Resource

class ContactViewModel(private val getUsers: GetUsersUseCase) : ViewModel() {

    val users: LiveData<Resource<List<User>>>
        get() = getUsers.execute(withScope = viewModelScope)
}
