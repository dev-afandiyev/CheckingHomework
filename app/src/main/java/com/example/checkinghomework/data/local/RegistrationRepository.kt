package com.example.checkinghomework.data.local

import com.example.checkinghomework.db.IUserDao
import com.example.checkinghomework.model.UserModel
import javax.inject.Inject

class RegistrationRepository
@Inject constructor(private var userDao: IUserDao)
    : IRegistrationRepository {

    override fun insert(userModel: UserModel) {
        userDao.insert(userModel)
    }

}