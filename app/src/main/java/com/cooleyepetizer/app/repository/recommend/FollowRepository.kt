package com.cooleyepetizer.app.repository.recommend

import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.common_lib.net.ResultTipObserver
import com.cooleyepetizer.app.common_lib.net.RetrofitEyeFactory
import com.cooleyepetizer.app.entity.eye_video.EyeIssueBean
import com.cooleyepetizer.app.service.FollowService

class FollowRepository {

    fun getFollowFirstData(resultCallBack: ResultCallBack<EyeIssueBean>?){
        val api = RetrofitEyeFactory.createService(FollowService::class.java)
        RetrofitEyeFactory.executeResult(api.getFollowFirstData(),object: ResultTipObserver<EyeIssueBean>(
        BaseApplication.instance){
            override fun onSuccess(result: EyeIssueBean?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }
        })
    }

    fun getMoreFollowData(url: String,resultCallBack: ResultCallBack<EyeIssueBean>?){
        val api = RetrofitEyeFactory.createService(FollowService::class.java)
        RetrofitEyeFactory.executeResult(api.getMoreFollowData(url),object: ResultTipObserver<EyeIssueBean>(
            BaseApplication.instance){
            override fun onSuccess(result: EyeIssueBean?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }
        })
    }
}