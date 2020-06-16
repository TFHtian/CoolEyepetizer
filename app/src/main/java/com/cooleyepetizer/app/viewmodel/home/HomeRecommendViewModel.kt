package com.cooleyepetizer.app.viewmodel.home

import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.mvvm.BaseRefreshViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.entity.eye_video.EyeItemResponse
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean
import com.cooleyepetizer.app.repository.home.HomeRepository

class HomeRecommendViewModel : BaseRefreshViewModel(){

    var nextPageUrl = ""
    val recommendList = MutableLiveData<ArrayList<EyeListItemBean>>()

    /*获取首页发现数据*/
    fun getHomeRecommendData (){
        setShowInitLoadView(true)
        HomeRepository().getHomeRecommendData(object:
            ResultCallBack<EyeItemResponse> {

            override fun onSuccess(result: EyeItemResponse?) {
                setShowInitLoadView(false)
                nextPageUrl = result!!.nextPageUrl
                recommendList.value = result?.itemList
            }

            override fun onFailure() {
                super.onFailure()
                setShowInitLoadView(false)
            }
        })
    }

    /*获取更多列表数据*/
    private fun getHomeLoadMoreData(url: String){
        HomeRepository().getHomeLoadMoreData(url, object: ResultCallBack<EyeItemResponse>{
            override fun onSuccess(result: EyeItemResponse?) {
                nextPageUrl = result!!.nextPageUrl
                recommendList.value = result?.itemList
                if (isLoadMore.get()!!) setEnableLoadMore(true) else setEnableRefresh(true)
            }
        })
    }

    override fun refreshData() {
        getHomeRecommendData()
    }

    override fun loadMoreData() {
        getHomeLoadMoreData(nextPageUrl)
    }
}