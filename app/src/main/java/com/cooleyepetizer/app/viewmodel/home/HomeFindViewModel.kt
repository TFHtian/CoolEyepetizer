package com.cooleyepetizer.app.viewmodel.home

import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.mvvm.BaseViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.entity.eye_video.EyeItemResponse
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean
import com.cooleyepetizer.app.repository.home.HomeRepository

class HomeFindViewModel : BaseViewModel(){

    val findList = MutableLiveData<ArrayList<EyeListItemBean>>()

    /*获取首页发现数据*/
    fun getHomeFindData(){
        setShowInitLoadView(true)
        HomeRepository().getHomeFindData(object:
            ResultCallBack<EyeItemResponse> {

            override fun onSuccess(result: EyeItemResponse?) {
                setShowInitLoadView(false)
                findList.value = result?.itemList
            }

            override fun onFailure() {
                super.onFailure()
                setShowInitLoadView(false)
            }
        })
    }

}