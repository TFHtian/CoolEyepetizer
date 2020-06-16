package com.cooleyepetizer.app.viewmodel.community

import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.mvvm.BaseRefreshViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.entity.eye_video.EyeItemResponse
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean
import com.cooleyepetizer.app.repository.community.CommunityRepository

class CommunityFollowViewModel : BaseRefreshViewModel(){

    var nextPageUrl = ""
    val followList = MutableLiveData<ArrayList<EyeListItemBean>>()

    /*获取首页发现数据*/
    fun getCommunityFollowData (){
        setShowInitLoadView(true)
        CommunityRepository().getCommunityFollowData(object:
            ResultCallBack<EyeItemResponse> {

            override fun onSuccess(result: EyeItemResponse?) {
                setShowInitLoadView(false)
                nextPageUrl = result!!.nextPageUrl
                followList.value = result?.itemList
            }

            override fun onFailure() {
                super.onFailure()
                setShowInitLoadView(false)
            }
        })
    }

    /*刷新列表数据*/
    private fun refreshCommunityFollowData(){
        CommunityRepository().getCommunityFollowData(object:
            ResultCallBack<EyeItemResponse> {

            override fun onSuccess(result: EyeItemResponse?) {
                nextPageUrl = result!!.nextPageUrl
                followList.value = result?.itemList
                if (isLoadMore.get()!!) setEnableLoadMore(true) else setEnableRefresh(true)
            }
        })
    }

    /*获取更多列表数据*/
    private fun getCommunityLoadMoreData(url: String){
        CommunityRepository().getCommunityLoadMoreData(url, object:
            ResultCallBack<EyeItemResponse> {
            override fun onSuccess(result: EyeItemResponse?) {
                nextPageUrl = result!!.nextPageUrl
                followList.value = result?.itemList
                if (isLoadMore.get()!!) setEnableLoadMore(true) else setEnableRefresh(true)
            }
        })
    }

    override fun refreshData() {
        refreshCommunityFollowData()
    }

    override fun loadMoreData() {
        getCommunityLoadMoreData(nextPageUrl)
    }
}