package com.example.checkinghomework.domain

import com.example.checkinghomework.data.local.RegistrationRepository
import com.example.checkinghomework.model.UserModel
import javax.inject.Inject

class RegistrationInteractor
@Inject constructor(private var registrationRepository: RegistrationRepository){

    fun insert(username: String, email: String, password: String){
        registrationRepository.insert(UserModel(username, email, password))
    }

}