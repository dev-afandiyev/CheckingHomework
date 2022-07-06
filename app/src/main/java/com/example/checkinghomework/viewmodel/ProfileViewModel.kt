package com.example.checkinghomework.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.checkinghomework.constants.NavigationConstants.CHAT_SCREEN
import com.example.checkinghomework.constants.NavigationConstants.NEWS_SCREEN
import com.example.checkinghomework.constants.NavigationConstants.VIDEOS_SCREEN
import com.example.checkinghomework.domain.RegistrationInteractor
import com.example.checkinghomework.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val interactor: RegistrationInteractor
) : BaseViewModel() {

    fun setTabTitle(i: Int): String {
        return when (i) {
            NEWS_SCREEN -> "News"
            VIDEOS_SCREEN -> "Videos"
            CHAT_SCREEN -> "Chat"
            else -> "View"
        }
    }

    fun getAllItem(): LiveData<UserModel?>? {
        return interactor.getAllItem()
    }

}