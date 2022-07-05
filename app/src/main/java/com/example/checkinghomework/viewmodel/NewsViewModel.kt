package com.example.checkinghomework.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.checkinghomework.data.repository.news.NewsRepository
import com.example.checkinghomework.domain.NewsInteractor
import com.example.checkinghomework.model.ArticleModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val interactor: NewsInteractor
) : BaseViewModel() {

    private val newsList = MutableLiveData<ArrayList<ArticleModel>>()

    fun getNewsLiveData(): LiveData<ArrayList<ArticleModel>> {
        return newsList
    }

    fun apiRequest() {
        if (newsList.value == null) {
            val result = interactor.request()
                .subscribe({
                    if (it.status == "ok") {
                        newsList.postValue(it.articles)
                    }
                }, {
                    Log.e("RequestError", it.message.toString())
                })
        }
    }

}