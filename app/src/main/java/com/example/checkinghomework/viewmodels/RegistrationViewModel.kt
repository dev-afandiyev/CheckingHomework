package com.example.checkinghomework.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.checkinghomework.domain.RegistrationInteractor
import com.example.checkinghomework.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.Observables
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val interactor: RegistrationInteractor
) : BaseViewModel() {

    private var buttonState = MutableLiveData(false)

    fun getButtonLiveState(): LiveData<Boolean> {
        return buttonState
    }

    fun validation(
        name: Observable<Boolean>,
        email: Observable<Boolean>,
        pass: Observable<Boolean>,
        passAgain: Observable<Boolean>
    ) {
        addDisposable(
            Observables
                .combineLatest(
                    name,
                    email,
                    pass,
                    passAgain
                ) { t1, t2, t3, t4 -> t1 && t2 && t3 && t4 }
                .observeOn(AndroidSchedulers.mainThread())
                .startWith(false)
                .subscribe { buttonState.postValue(it) }
        )
    }


}