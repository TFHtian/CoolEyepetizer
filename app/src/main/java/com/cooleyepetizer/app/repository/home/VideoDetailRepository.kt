package com.cooleyepetizer.app.repository.home

import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.common_lib.net.ResultTipObserver
import com.cooleyepetizer.app.common_lib.net.RetrofitEyeFactory
import com.cooleyepetizer.app.entity.eye_video.EyeItemResponse
import com.cooleyepetizer.app.service.VideoPlayService

class VideoDetailRepository {

    fun getVideoDetail(id : Long,resultCallBack: ResultCallBack<EyeItemResponse>?){
        val api = RetrofitEyeFactory.createService(VideoPlayService ::class.java)
        RetrofitEyeFactory.executeResult(api.getVideoDetail(id),object: ResultTipObserver<EyeItemResponse>(BaseApplication.instance){
            override fun onSuccess(result: EyeItemResponse?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }
        })
    }

}