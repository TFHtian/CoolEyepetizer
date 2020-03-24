package com.cooleyepetizer.app.common_lib.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * 基类列表VM
 */
abstract class BaseViewModel : ViewModel() {

    var showInitLoadView = MutableLiveData<Boolean>()
    var showTransLoadingView = MutableLiveData<Boolean>()
    var showNoDataView = MutableLiveData<Boolean>()
    var showNetWorkErrView = MutableLiveData<Boolean>()

    fun setShowInitLoadView(value: Boolean){
        showInitLoadView.value =value
    }

    fun setShowTransLoadingView(value: Boolean) {
        showTransLoadingView.value = value
    }

    fun setShowNoDataView(value: Boolean){
        showNoDataView.value =value
    }

    fun setShowNetWorkErrView(value: Boolean){
        showNetWorkErrView.value =value
    }
}