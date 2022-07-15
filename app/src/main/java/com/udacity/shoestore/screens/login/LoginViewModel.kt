package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class LoginViewModel : ViewModel() {
    private val _eventBtnClicked = MutableLiveData<Boolean>()
    val eventBtnClicked: LiveData<Boolean>
        get() = _eventBtnClicked

    init {
        Timber.i("Created ViewModel")
        _eventBtnClicked.value = false

    }

    fun onBtnClicked() {
        _eventBtnClicked.value = true
    }

    fun onBtnClickedComplete() {
        _eventBtnClicked.value = false
    }
}