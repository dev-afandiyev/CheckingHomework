package com.example.checkinghomework.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.checkinghomework.domain.login.LoginInteractor
import com.example.checkinghomework.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginInteractor: LoginInteractor
) : BaseViewModel() {

    val logPassState = MutableLiveData<UserModel>()

    fun getByLogin(username: String?, pass: String?) : UserModel? {
        return loginInteractor.getByLogin(username, pass)
    }

}