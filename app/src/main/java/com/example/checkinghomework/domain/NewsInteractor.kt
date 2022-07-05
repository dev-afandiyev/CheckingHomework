package com.example.checkinghomework.domain

import com.example.checkinghomework.data.repository.news.NewsRepository
import com.example.checkinghomework.model.ResponseModel
import io.reactivex.Single
import javax.inject.Inject

class NewsInteractor @Inject constructor(
    private val newsRepository: NewsRepository
) {

    fun request(): Single<ResponseModel> {
        return newsRepository.request()
    }

}