package com.cooleyepetizer.app.common_lib.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * 基类列表VM
 */
abstract class BaseViewModel: ViewModel() {

//    private var mUIChangeLiveData: UIChangeLiveData? = null

    private val showInitLoadView = MutableLiveData<Boolean>()

    fun postShowInitLoadView(show: Boolean) {

        showInitLoadView?.value = show
    }

    fun getInitUI():MutableLiveData<Boolean> {
        return showInitLoadView
    }



//    fun getUC(): UIChangeLiveData {
//        if (mUIChangeLiveData == null) {
//            mUIChangeLiveData = UIChangeLiveData()
//        }
//        return mUIChangeLiveData as UIChangeLiveData
//    }
//
//    inner class UIChangeLiveData : MutableLiveData<Boolean>() {
//
//        fun getShowInitLoadView(): MutableLiveData<Boolean> {
//            return  showInitLoadView
//        }
//    }



}