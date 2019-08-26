package com.cooleyepetizer.app.common_lib.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * 基类列表VM
 */
abstract class BaseViewModel: ViewModel() {

    private var mUIChangeLiveData: UIChangeLiveData? = null

    private var showNoDataView: MutableLiveData<Boolean>? = null

    fun getUC(): UIChangeLiveData {
        if (mUIChangeLiveData == null) {
            mUIChangeLiveData = UIChangeLiveData()
        }
        return mUIChangeLiveData as UIChangeLiveData
    }

    inner class UIChangeLiveData : MutableLiveData<Boolean>() {

        fun getShowNoDataViewEvent(): MutableLiveData<Boolean> {
            return showNoDataView = MutableLiveData(showNoDataView)
        }

    }

    protected fun createLiveData(liveData: MutableLiveData<Boolean>?): MutableLiveData<Boolean> {
        if (liveData == null) {
            liveData = MutableLiveData()
        }
        return liveData
    }

}