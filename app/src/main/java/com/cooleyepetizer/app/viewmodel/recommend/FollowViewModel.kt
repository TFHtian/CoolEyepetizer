package com.cooleyepetizer.app.viewmodel.recommend

import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.mvvm.BaseRefreshViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.entity.eye_video.EyeIssueBean
import com.cooleyepetizer.app.entity.eye_video.EyeItemBean
import com.cooleyepetizer.app.repository.recommend.FollowRepository

class FollowViewModel : BaseRefreshViewModel() {

    var nextPageUrl = ""
    val followList = MutableLiveData<ArrayList<EyeItemBean>>()

    fun getFollowFirstData(){
        setShowInitLoadView(true)
        FollowRepository().getFollowFirstData(object: ResultCallBack<EyeIssueBean>{
            override fun onSuccess(result: EyeIssueBean?) {
                setShowInitLoadView(false)
                nextPageUrl = result!!.nextPageUrl
                followList.value = result!!.itemList
            }

            override fun onFailure() {
                setShowInitLoadView(false)
            }
        })
    }

    private fun getMoreFollowData(url: String){
        setShowInitLoadView(true)
        FollowRepository()
            .getMoreFollowData(url,object: ResultCallBack<EyeIssueBean>{
            override fun onSuccess(result: EyeIssueBean?) {
                setShowInitLoadView(false)
                nextPageUrl = result!!.nextPageUrl
                followList.value = result!!.itemList
            }

            override fun onFailure() {
                setShowInitLoadView(false)
            }
        })
    }

    override fun refreshData() {
        getFollowFirstData()
    }

    override fun loadMoreData() {
        getMoreFollowData(nextPageUrl)
    }

}