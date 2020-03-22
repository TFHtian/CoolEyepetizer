package com.cooleyepetizer.app.common_lib.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * 基类列表VM
 */
abstract class BaseViewModel : ViewModel() {

    var absLiveData = MutableLiveData<Boolean>()
        private set

    fun setAbsLiveDataValue(value: Boolean) {
        absLiveData.value = value
    }

    fun postAbsLiveDataValue(value: Boolean) {
        absLiveData.postValue(value)
    }


    private val showInitLoadView = MutableLiveData<Boolean>()

    fun postShowInitLoadView(show: Boolean) {

        showInitLoadView?.value = show
    }

    fun getInitUI(): MutableLiveData<Boolean> {
        return showInitLoadView
    }


    private var mData: MutableLiveData<Boolean>? = null
    fun getData(): MutableLiveData<Boolean> {
        if (mData == null) {
            mData = MutableLiveData()
        }
        return mData as MutableLiveData<Boolean>
    }

    fun setData(data: Boolean) {
        //更新livedata中的值
        mData!!.value = data
    }


}