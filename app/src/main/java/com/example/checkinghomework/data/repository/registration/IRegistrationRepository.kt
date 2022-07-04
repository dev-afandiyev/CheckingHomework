package com.example.checkinghomework.data.repository.registration

import com.example.checkinghomework.model.UserModel

interface IRegistrationRepository {

    fun insert(userModel: UserModel)

}