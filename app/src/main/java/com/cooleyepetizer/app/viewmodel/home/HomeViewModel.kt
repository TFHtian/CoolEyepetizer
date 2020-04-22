package com.cooleyepetizer.app.viewmodel.home

import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.mvvm.BaseRefreshViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.entity.eye_video.EyeCoverBean
import com.cooleyepetizer.app.entity.eye_video.EyeItemBean
import com.cooleyepetizer.app.entity.eye_video.EyeVideoResponse
import com.cooleyepetizer.app.repository.home.HomeRepository

class HomeViewModel : BaseRefreshViewModel(){

    private val num = 1
    var nextPageUrl = ""
    var firstPageUrl = ""
    val dataList = MutableLiveData<ArrayList<EyeItemBean>>()
    var bannerList = MutableLiveData<ArrayList<EyeCoverBean>>()

    /**
     * 获取第一条数据(把第一页的数据作为banner，并且获得nextUrl)
     */
    fun getHomeFirstData(){
        setShowInitLoadView(true)
        HomeRepository().getHomeFirstData(num, object : ResultCallBack<EyeVideoResponse> {

            override fun onSuccess(result: EyeVideoResponse?) {
                setShowInitLoadView(false)
                firstPageUrl = result!!.nextPageUrl
                getMoreHomeData(result!!.nextPageUrl)
                val listFirst = result!!.issueList[0].itemList
                val videoList = ArrayList<EyeCoverBean>()
                for (value in listFirst){
                    if (value.type=="video"){
                        videoList.add(value.data.cover)
                    }
                }
                bannerList.value =videoList
            }

            override fun onFailure() {
                setShowInitLoadView(false)
            }
        })
    }

    private fun getMoreHomeData(url: String){
        HomeRepository().getMoreHomeData(url, object: ResultCallBack<EyeVideoResponse>{
            override fun onSuccess(result: EyeVideoResponse?) {
                nextPageUrl = result!!.nextPageUrl
                /*刷选出video和textHeader*/
                val screenList = ArrayList<EyeItemBean>()
                for (value in result!!.issueList[0].itemList){
                    if (value.type == "video" || value.type == "textHeader"){
                        screenList.add(value)
                    }
                }
                dataList.value = screenList
                if (isLoadMore.get()!!) setEnableLoadMore(true) else setEnableRefresh(true)
            }
        })
    }

    override fun refreshData() {
        getMoreHomeData(firstPageUrl)
    }

    override fun loadMoreData() {
        getMoreHomeData(nextPageUrl)
    }

}