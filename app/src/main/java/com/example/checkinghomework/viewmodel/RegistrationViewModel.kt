package com.example.checkinghomework.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.checkinghomework.domain.RegistrationInteractor
import com.example.checkinghomework.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel
@Inject constructor(private val interactor: RegistrationInteractor)
    : BaseViewModel() {

    val userState = MutableLiveData<UserModel>()

    fun insertParam(username: String, email: String, password: String){
        interactor.insert(username, email, password)
    }

}