package com.cooleyepetizer.app.common_lib.mvvm

import androidx.lifecycle.MutableLiveData

abstract class BaseRefreshViewModel : BaseViewModel(){

    var enableRefresh = MutableLiveData<Boolean>()
    var enableLoadMore = MutableLiveData<Boolean>()

    fun setEnableRefresh(value: Boolean) {
        enableRefresh.value = value
    }

    fun setEnableLoadMore(value: Boolean){
        enableLoadMore.value =value
    }

    abstract fun refreshData()

    abstract fun loadMoreData()
}