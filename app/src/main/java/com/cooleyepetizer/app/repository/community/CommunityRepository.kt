package com.cooleyepetizer.app.repository.community

import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.common_lib.net.ResultTipObserver
import com.cooleyepetizer.app.common_lib.net.RetrofitEyeFactory
import com.cooleyepetizer.app.entity.eye_video.EyeItemResponse
import com.cooleyepetizer.app.service.CommunityService
import com.cooleyepetizer.app.service.HomeService

class CommunityRepository {

    fun  getCommunityRecommendData(resultCallBack: ResultCallBack<EyeItemResponse>?){
        val api = RetrofitEyeFactory.createService(CommunityService::class.java)
        RetrofitEyeFactory.executeResult(api.getCommunityRecommendData(), object: ResultTipObserver<EyeItemResponse>(
            BaseApplication.instance) {
            override fun onSuccess(result: EyeItemResponse?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }
        })
    }

    fun  getCommunityFollowData(resultCallBack: ResultCallBack<EyeItemResponse>?){
        val api = RetrofitEyeFactory.createService(CommunityService::class.java)
        RetrofitEyeFactory.executeResult(api.getCommunityFollowData(), object: ResultTipObserver<EyeItemResponse>(
            BaseApplication.instance) {
            override fun onSuccess(result: EyeItemResponse?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }
        })
    }

    fun getCommunityLoadMoreData(url: String,resultCallBack: ResultCallBack<EyeItemResponse>?){
        val api = RetrofitEyeFactory.createService(HomeService::class.java)
        RetrofitEyeFactory.executeResult(api.getHomeLoadMoreData(url),object:
            ResultTipObserver<EyeItemResponse>(BaseApplication.instance){
            override fun onSuccess(result: EyeItemResponse?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }
        })
    }

}