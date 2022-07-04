package com.example.checkinghomework.data.remote

import com.example.checkinghomework.model.ResponseModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IRetrofitApi {

    @GET("v2/top-headlines")
    fun dataRequest(
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String
    ): Single<ResponseModel>

}