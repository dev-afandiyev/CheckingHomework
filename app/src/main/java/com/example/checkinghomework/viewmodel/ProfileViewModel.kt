package com.example.checkinghomework.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.checkinghomework.model.ProfileModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : BaseViewModel() {

    val profileLiveData = MutableLiveData<List<ProfileModel>>()

    private val list = mutableListOf<ProfileModel>()

    fun getItem() : List<ProfileModel> {
        list.add(ProfileModel("News"))
        list.add(ProfileModel("Videos"))
        list.add(ProfileModel("Chat"))
        return list
    }

    fun setList() {
        profileLiveData.value = getItem()
    }

}