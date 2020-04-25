package com.cooleyepetizer.app.viewmodel.home

import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.mvvm.BaseViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.entity.eye_video.EyeIssueBean
import com.cooleyepetizer.app.entity.eye_video.EyeItemBean
import com.cooleyepetizer.app.repository.home.RankRepository

class RankViewModel : BaseViewModel(){

    val rankList = MutableLiveData<List<EyeItemBean>>()

    fun getIssueData(url: String){
        setShowInitLoadView(true)
        RankRepository().getIssueData(url,object: ResultCallBack<EyeIssueBean>{
            override fun onSuccess(result: EyeIssueBean?) {
                setShowInitLoadView(false)
                rankList.value = result?.itemList
            }
        })
    }
}
