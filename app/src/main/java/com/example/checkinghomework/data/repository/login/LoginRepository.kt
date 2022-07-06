package com.example.checkinghomework.data.repository.login

import com.example.checkinghomework.db.IUserDao
import com.example.checkinghomework.model.UserModel
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val iUserDao: IUserDao
    ) : ILoginRepository {

    override fun getByLogin(username: String?, pass: String?): UserModel? {
       return iUserDao.getByLogin(username, pass)
    }

}