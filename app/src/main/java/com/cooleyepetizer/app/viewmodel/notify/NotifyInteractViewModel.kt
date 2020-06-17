package com.cooleyepetizer.app.viewmodel.notify

import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.mvvm.BaseRefreshViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.entity.notify.NotifyInteractBean
import com.cooleyepetizer.app.entity.notify.NotifyInteractItemBean
import com.cooleyepetizer.app.repository.notify.NotifyRepository

class NotifyInteractViewModel : BaseRefreshViewModel(){

    var nextPageUrl = ""
    val interactList = MutableLiveData<ArrayList<NotifyInteractItemBean>>()

    /*获取首页发现数据*/
    fun getNotifyInteractData (){
        setShowInitLoadView(true)
        NotifyRepository().getNotifyInteractData(object:
            ResultCallBack<NotifyInteractBean> {

            override fun onSuccess(result: NotifyInteractBean?) {
                setShowInitLoadView(false)
                nextPageUrl = result!!.nextPageUrl
                interactList.value = result?.itemList
            }

            override fun onFailure() {
                super.onFailure()
                setShowInitLoadView(false)
            }
        })
    }

    private fun refreshNotifyInteractData(){
        NotifyRepository().getNotifyInteractData(object:
            ResultCallBack<NotifyInteractBean> {

            override fun onSuccess(result: NotifyInteractBean?) {
                nextPageUrl = result!!.nextPageUrl
                interactList.value = result?.itemList
                if (isLoadMore.get()!!) setEnableLoadMore(true) else setEnableRefresh(true)
            }
        })
    }

    private fun getMoreNotifyInteractData(url: String){
        NotifyRepository().getMoreNotifyInteractData(url,object:
            ResultCallBack<NotifyInteractBean> {

            override fun onSuccess(result: NotifyInteractBean?) {
                nextPageUrl = result!!.nextPageUrl
                interactList.value = result?.itemList
                if (isLoadMore.get()!!) setEnableLoadMore(true) else setEnableRefresh(true)
            }
        })
    }


    override fun refreshData() {
        refreshNotifyInteractData()
    }

    override fun loadMoreData() {
        getMoreNotifyInteractData(nextPageUrl)
    }
}