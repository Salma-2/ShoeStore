package com.udacity.shoestore.screens.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeListViewModel : ViewModel() {
    private val _eventAddNewShoe = MutableLiveData<Boolean>()
    val eventAddNewShoe: LiveData<Boolean>
        get() = _eventAddNewShoe

    init {
        Timber.i("View Model Created")
        _eventAddNewShoe.value = false

    }

    fun onAddNewShoe() {
        _eventAddNewShoe.value = true
    }

    fun onAddNewShoeComplete() {
        _eventAddNewShoe.value = false
    }
}