package com.example.checkinghomework.viewmodels

import androidx.lifecycle.LiveData
import com.example.checkinghomework.domain.main.MainInteractor
import com.example.checkinghomework.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel@Inject constructor(
    private var mainInteractor: MainInteractor
) : BaseViewModel() {

    fun getAllItem(): LiveData<UserModel?>? {
        return mainInteractor.getAllItem()
    }

}