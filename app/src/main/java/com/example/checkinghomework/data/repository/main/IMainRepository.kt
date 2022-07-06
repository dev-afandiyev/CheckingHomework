package com.example.checkinghomework.data.repository.main

import androidx.lifecycle.LiveData
import com.example.checkinghomework.model.UserModel

interface IMainRepository {

    fun getAllItem(): LiveData<UserModel?>?
}