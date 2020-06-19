package com.cooleyepetizer.app.viewmodel.home

import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.mvvm.BaseRefreshViewModel
import com.cooleyepetizer.app.common_lib.mvvm.BaseViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.entity.eye_video.EyeItemResponse
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean
import com.cooleyepetizer.app.entity.eye_video.EyeRankTabInfo
import com.cooleyepetizer.app.repository.home.ThemeRepository

class ThemeViewModel : BaseRefreshViewModel(){

    val tabInfo = MutableLiveData<EyeRankTabInfo>()
    val themeList = MutableLiveData<List<EyeListItemBean>>()

    fun getThemeTabInfo(){
        setShowInitLoadView(true)
        ThemeRepository().getThemeTabInfo(object: ResultCallBack<EyeRankTabInfo>{
            override fun onSuccess(result: EyeRankTabInfo?) {
                setShowInitLoadView(false)
                tabInfo.value = result
            }

            override fun onFailure() {
                setShowInitLoadView(false)
            }
        })
    }

    fun getThemeListData(url: String){
        ThemeRepository().getThemeListData(url,object: ResultCallBack<EyeItemResponse>{
            override fun onSuccess(result: EyeItemResponse?) {
                themeList.value = result?.itemList
            }

        })
    }

    override fun refreshData() {

    }

    override fun loadMoreData() {

    }


}