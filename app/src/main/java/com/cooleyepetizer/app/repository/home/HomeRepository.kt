package com.cooleyepetizer.app.repository.home

import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.common_lib.net.ResultTipObserver
import com.cooleyepetizer.app.common_lib.net.RetrofitEyeFactory
import com.cooleyepetizer.app.entity.eye_video.EyeVideoResponse
import com.cooleyepetizer.app.service.HomeService

class HomeRepository {

    fun  getHomeFirstData(num: Int,resultCallBack: ResultCallBack<EyeVideoResponse>?){
        val api = RetrofitEyeFactory.createService(HomeService::class.java)
        RetrofitEyeFactory.executeResult(api.getHomeFirstData(num), object: ResultTipObserver<EyeVideoResponse>(
            BaseApplication.instance) {
            override fun onSuccess(result: EyeVideoResponse?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }
        })
    }

    fun getMoreHomeData( url: String, resultCallBack: ResultCallBack<EyeVideoResponse>?){
        val api = RetrofitEyeFactory.createService(HomeService::class.java)
        RetrofitEyeFactory.executeResult(api.getMoreHomeData(url),object:
            ResultTipObserver<EyeVideoResponse>(BaseApplication.instance){
            override fun onSuccess(result: EyeVideoResponse?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }
        })
    }
}