package com.cooleyepetizer.app.common_lib.mvvm

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData

abstract class BaseRefreshViewModel : BaseViewModel(){

    var enableRefresh = MutableLiveData<Boolean>()
    var enableLoadMore = MutableLiveData<Boolean>()
    val isLoadMore = ObservableField<Boolean>()

    init {
        isLoadMore.set(false)
    }

    fun setEnableRefresh(value: Boolean) {
        enableRefresh.value = value
    }

    fun setEnableLoadMore(value: Boolean){
        enableLoadMore.value =value
    }

    open fun refresh() {
        isLoadMore.set(false)
        refreshData()
    }

    open fun loadMore() {
        isLoadMore.set(true)
        loadMoreData()
    }

    abstract fun refreshData()

    abstract fun loadMoreData()
}