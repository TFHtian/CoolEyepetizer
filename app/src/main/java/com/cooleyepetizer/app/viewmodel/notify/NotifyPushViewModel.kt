package com.cooleyepetizer.app.viewmodel.notify

import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.mvvm.BaseRefreshViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.entity.notify.NotifyMessageBean
import com.cooleyepetizer.app.entity.notify.NotifyPushBean
import com.cooleyepetizer.app.repository.notify.NotifyRepository

class NotifyPushViewModel : BaseRefreshViewModel(){

    var nextPageUrl = ""
    val pushList = MutableLiveData<ArrayList<NotifyMessageBean>>()

    /*获取首页发现数据*/
    fun getNotifyPushData (){
        setShowInitLoadView(true)
        NotifyRepository().getNotifyPushData(object:
            ResultCallBack<NotifyPushBean> {

            override fun onSuccess(result: NotifyPushBean?) {
                setShowInitLoadView(false)
                nextPageUrl = result!!.nextPageUrl
                pushList.value = result?.messageList
            }

            override fun onFailure() {
                super.onFailure()
                setShowInitLoadView(false)
            }
        })
    }

    private fun refreshNotifyPushData (){
        NotifyRepository().getNotifyPushData(object:
            ResultCallBack<NotifyPushBean> {

            override fun onSuccess(result: NotifyPushBean?) {
                nextPageUrl = result!!.nextPageUrl
                pushList.value = result?.messageList
                if (isLoadMore.get()!!) setEnableLoadMore(true) else setEnableRefresh(true)
            }

        })
    }

    private fun getMoreNotifyPushData(url: String){
        NotifyRepository().getMoreNotifyPushData(url,object:
            ResultCallBack<NotifyPushBean> {

            override fun onSuccess(result: NotifyPushBean?) {
                setShowInitLoadView(false)
                nextPageUrl = result!!.nextPageUrl
                pushList.value = result?.messageList
                if (isLoadMore.get()!!) setEnableLoadMore(true) else setEnableRefresh(true)
            }

        })
    }

    override fun refreshData() {
        refreshNotifyPushData()
    }

    override fun loadMoreData() {
        getMoreNotifyPushData(nextPageUrl)
    }



}