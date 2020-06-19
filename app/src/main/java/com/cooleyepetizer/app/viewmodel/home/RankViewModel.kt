package com.cooleyepetizer.app.viewmodel.home

import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.mvvm.BaseViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.entity.eye_video.*
import com.cooleyepetizer.app.repository.home.RankRepository

class RankViewModel : BaseViewModel(){

    val tabInfo = MutableLiveData<EyeRankTabInfo>()
    val rankList = MutableLiveData<List<EyeListItemBean>>()

    /*获取rank_tab信息*/
    fun getRankTabInfo(){
        setShowInitLoadView(true)
        RankRepository().getRankTabInfo(object: ResultCallBack<EyeRankTabInfo>{
            override fun onSuccess(result: EyeRankTabInfo?) {
                setShowInitLoadView(false)
                tabInfo.value = result
            }

            override fun onFailure() {
                setShowInitLoadView(false)
            }
        })
    }

    fun getRankListData(url: String){
        setShowInitLoadView(true)
        RankRepository().getRankListData(url,object: ResultCallBack<EyeItemResponse>{
            override fun onSuccess(result: EyeItemResponse?) {
                setShowInitLoadView(false)
                rankList.value = result?.itemList
            }
        })
    }
}
