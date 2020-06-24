package com.cooleyepetizer.app.viewmodel.home

import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.mvvm.BaseViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.entity.eye_video.EyeItemResponse
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean
import com.cooleyepetizer.app.repository.home.VideoDetailRepository

class VideoPlayViewModel : BaseViewModel(){

    val videoDetailList = MutableLiveData<ArrayList<EyeListItemBean>>()

    fun getVideoDetail(id:Long){
        VideoDetailRepository().getVideoDetail(id,object: ResultCallBack<EyeItemResponse>{

            override fun onSuccess(result: EyeItemResponse?) {
                videoDetailList.value = result?.itemList
            }
        })
    }

}