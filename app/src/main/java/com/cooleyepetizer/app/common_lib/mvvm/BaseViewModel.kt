package com.cooleyepetizer.app.common_lib.mvvm

import android.os.Handler
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
        changeValue(value,showInitLoadView)
    }

    fun setShowTransLoadingView(value: Boolean) {
        changeValue(value,showTransLoadingView)
    }

    fun setShowNoDataView(value: Boolean){
        showNoDataView.value =value
    }

    fun setShowNetWorkErrView(value: Boolean){
        showNetWorkErrView.value =value
    }

    private fun changeValue(value: Boolean, changeView : MutableLiveData<Boolean>){
        when(value) {
            true -> changeView.value =value
            false ->
                Handler().postDelayed(Runnable {
                    changeView.value =value
                },1000)
        }
    }
}