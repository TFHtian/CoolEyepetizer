package com.cooleyepetizer.app.viewmodel.home

import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.mvvm.BaseRefreshViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.entity.eye_video.EyeItemResponse
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean
import com.cooleyepetizer.app.repository.home.HomeRepository

class HomeDailyViewModel : BaseRefreshViewModel(){

    var nextPageUrl = ""
    val dailyList = MutableLiveData<ArrayList<EyeListItemBean>>()

    /*获取首页发现数据*/
    fun getHomeDailyData (){
        setShowInitLoadView(true)
        HomeRepository().getHomeDailyData(object:
            ResultCallBack<EyeItemResponse> {

            override fun onSuccess(result: EyeItemResponse?) {
                setShowInitLoadView(false)
                nextPageUrl = result!!.nextPageUrl
                dailyList.value = result?.itemList
            }

            override fun onFailure() {
                super.onFailure()
                setShowInitLoadView(false)
            }
        })
    }

    /*获取首页发现数据*/
    fun refreshHomeDailyData (){
        HomeRepository().getHomeDailyData(object:
            ResultCallBack<EyeItemResponse> {

            override fun onSuccess(result: EyeItemResponse?) {
                nextPageUrl = result!!.nextPageUrl
                dailyList.value = result?.itemList
                if (isLoadMore.get()!!) setEnableLoadMore(true) else setEnableRefresh(true)
            }
        })
    }

    /*获取更多列表数据*/
    private fun getHomeLoadMoreData(url: String){
        HomeRepository().getHomeLoadMoreData(url, object: ResultCallBack<EyeItemResponse>{
            override fun onSuccess(result: EyeItemResponse?) {
                nextPageUrl = result!!.nextPageUrl
                dailyList.value = result?.itemList
                if (isLoadMore.get()!!) setEnableLoadMore(true) else setEnableRefresh(true)
            }
        })
    }

    override fun refreshData() {
        refreshHomeDailyData()
    }

    override fun loadMoreData() {
        getHomeLoadMoreData(nextPageUrl)
    }
}