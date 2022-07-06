package com.example.checkinghomework.viewmodel

import com.example.checkinghomework.constants.NavigationConstants.CHAT_SCREEN
import com.example.checkinghomework.constants.NavigationConstants.NEWS_SCREEN
import com.example.checkinghomework.constants.NavigationConstants.VIDEOS_SCREEN
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : BaseViewModel() {

    fun setTabTitle(i: Int): String {
        return when (i) {
            NEWS_SCREEN -> "News"
            VIDEOS_SCREEN -> "Videos"
            CHAT_SCREEN -> "Chat"
            else -> "View"
        }
    }

}