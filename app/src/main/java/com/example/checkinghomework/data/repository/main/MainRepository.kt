package com.example.checkinghomework.data.repository.main

import androidx.lifecycle.LiveData
import com.example.checkinghomework.db.IUserDao
import com.example.checkinghomework.model.UserModel
import javax.inject.Inject

class MainRepository @Inject constructor(
    private var userDao: IUserDao
) : IMainRepository {

    override fun getAllItem(): LiveData<UserModel?>? {
        return userDao.getAllItem()
    }

}