package com.example.checkinghomework.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    open fun onBackPressed() {}

    fun addDisposable(disposable: Disposable) = compositeDisposable.add(disposable)

    fun clearDisposables() {
        compositeDisposable.clear()
    }

    override fun onCleared() {
        super.onCleared()
        clearDisposables()
    }

}