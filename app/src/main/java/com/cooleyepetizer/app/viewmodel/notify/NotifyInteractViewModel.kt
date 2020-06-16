package com.cooleyepetizer.app.viewmodel.notify

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.mvvm.BaseRefreshViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.entity.notify.NotifyInteractBean
import com.cooleyepetizer.app.entity.notify.NotifyInteractItemBean
import com.cooleyepetizer.app.repository.notify.NotifyRepository
import com.google.gson.Gson

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
                Log.e("nnnnnn",Gson().toJson(result))
                nextPageUrl = result!!.nextPageUrl
                interactList.value = result?.itemList
            }

            override fun onFailure() {
                super.onFailure()
                setShowInitLoadView(false)
            }
        })
    }

    override fun refreshData() {

    }

    override fun loadMoreData() {

    }
}