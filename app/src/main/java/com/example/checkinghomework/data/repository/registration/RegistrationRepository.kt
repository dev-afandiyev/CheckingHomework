package com.example.checkinghomework.data.repository.registration

import androidx.lifecycle.LiveData
import com.example.checkinghomework.db.IUserDao
import com.example.checkinghomework.model.UserModel
import javax.inject.Inject

class RegistrationRepository @Inject constructor(
    private var userDao: IUserDao
) : IRegistrationRepository {

    override fun insert(userModel: UserModel) {
        userDao.insert(userModel)
    }

    fun getAllItem(): LiveData<UserModel?>? {
       return userDao.getAllItem()
    }

}