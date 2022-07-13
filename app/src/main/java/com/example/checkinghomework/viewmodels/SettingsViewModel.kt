package com.example.checkinghomework.viewmodels

import androidx.lifecycle.LiveData
import com.example.checkinghomework.domain.RegistrationInteractor
import com.example.checkinghomework.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val interactor: RegistrationInteractor
) : BaseViewModel() {

    fun getUserData(): LiveData<UserModel?>? {
        return interactor.getAllItem()
    }

}