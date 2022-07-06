package com.example.checkinghomework.domain

import androidx.lifecycle.LiveData
import com.example.checkinghomework.data.repository.registration.RegistrationRepository
import com.example.checkinghomework.model.UserModel
import javax.inject.Inject

class RegistrationInteractor @Inject constructor(
    private var registrationRepository: RegistrationRepository
) {

    fun insert(username: String, email: String, password: String) {
        registrationRepository.insert(UserModel(username, email, password))
    }

    fun getAllItem(): LiveData<UserModel?>? {
        return registrationRepository.getAllItem()
    }

}