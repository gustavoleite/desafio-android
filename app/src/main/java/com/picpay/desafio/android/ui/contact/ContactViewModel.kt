package com.picpay.desafio.android.ui.contact

import androidx.lifecycle.*
import com.picpay.desafio.android.data.remote.network.Resource
import com.picpay.desafio.android.domain.user.model.User
import com.picpay.desafio.android.domain.user.usecase.GetUsersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModel(private val getUsers: GetUsersUseCase) : ViewModel() {

    val users = MutableLiveData<Resource<List<User>>>()

    fun loadUserList() {
        viewModelScope.launch {
            getUsers.execute(Dispatchers.IO).observeForever {
                users.value = it
            }
        }
    }
}
