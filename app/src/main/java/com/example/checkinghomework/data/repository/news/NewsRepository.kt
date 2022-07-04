package com.example.checkinghomework.data.repository.news

import com.example.checkinghomework.constants.Constants.API_KEY
import com.example.checkinghomework.data.remote.IRetrofitApi
import com.example.checkinghomework.model.ResponseModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val api: IRetrofitApi
) {

    fun request(): Single<ResponseModel> {
        return api.dataRequest("bbc-news", API_KEY).retry()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}