package com.example.checkinghomework.data.local

import com.example.checkinghomework.model.UserModel

interface IRegistrationRepository {

    fun insert(userModel: UserModel)

}