package com.example.checkinghomework.domain.login

import com.example.checkinghomework.data.repository.login.LoginRepository
import com.example.checkinghomework.model.UserModel
import javax.inject.Inject

class LoginInteractor @Inject constructor(
    private val loginRepository: LoginRepository
    ) {

    fun getByLogin(username: String?, pass: String?) : UserModel? {
       return loginRepository.getByLogin(username, pass)
    }

}