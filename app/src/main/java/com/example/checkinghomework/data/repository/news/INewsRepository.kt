package com.example.checkinghomework.data.repository.news

import com.example.checkinghomework.model.ResponseModel
import io.reactivex.Single

interface INewsRepository {

    fun request(): Single<ResponseModel>

}