package com.example.checkinghomework.domain.main

import androidx.lifecycle.LiveData
import com.example.checkinghomework.data.repository.main.MainRepository
import com.example.checkinghomework.model.UserModel
import javax.inject.Inject

class MainInteractor @Inject constructor(
    private var mainRepository: MainRepository
) {

    fun getAllItem(): LiveData<UserModel?>? {
        return mainRepository.getAllItem()
    }

}