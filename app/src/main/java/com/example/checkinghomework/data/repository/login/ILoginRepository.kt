package com.example.checkinghomework.data.repository.login

import com.example.checkinghomework.model.UserModel

interface ILoginRepository {

    fun getByLogin(email: String?, pass: String?): UserModel?

}