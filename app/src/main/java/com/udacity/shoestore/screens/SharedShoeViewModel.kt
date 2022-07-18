package com.udacity.shoestore.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class SharedShoeViewModel : ViewModel() {

    // Save
    private val _eventSave = MutableLiveData<Boolean>()
    val eventSave: LiveData<Boolean>
        get() = _eventSave

    // Cancel
    private val _eventCancel = MutableLiveData<Boolean>()
    val eventCancel: LiveData<Boolean>
        get() = _eventCancel

    private val _eventAddNewShoe = MutableLiveData<Boolean>()
    val eventAddNewShoe: LiveData<Boolean>
        get() = _eventAddNewShoe


    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    val shoe = MutableLiveData<Shoe>()


    init {
        _eventSave.value = false
        _eventCancel.value = false
        _eventAddNewShoe.value = false

        _shoeList.value = ArrayList()
    }

    // onCancelClicked
    fun onCancel() {
        _eventCancel.value = true
    }

    fun onCancelComplete() {
        _eventCancel.value = false

    }

    // onSaveClicked
    fun onSave() {
        _eventSave.value = true
        _shoeList.value?.add(shoe.value!!)
    }

    fun onSaveComplete() {
        _eventSave.value = false
    }

    // onFabClicked
    fun onAddNewShoe() {
        _eventAddNewShoe.value = true
        shoe.value = Shoe()
    }

    fun onAddNewShoeComplete() {
        _eventAddNewShoe.value = false
    }

}