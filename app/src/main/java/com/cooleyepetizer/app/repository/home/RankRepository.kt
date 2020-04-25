package com.cooleyepetizer.app.repository.home

import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.common_lib.net.ResultTipObserver
import com.cooleyepetizer.app.common_lib.net.RetrofitEyeFactory
import com.cooleyepetizer.app.entity.eye_video.EyeIssueBean
import com.cooleyepetizer.app.entity.eye_video.EyeRankTabInfo
import com.cooleyepetizer.app.service.RankService

class RankRepository {

    fun getRankTabInfo(resultCallBack: ResultCallBack<EyeRankTabInfo>?){
        val api = RetrofitEyeFactory.createService(RankService::class.java)
        RetrofitEyeFactory.executeResult(api.getRankTabInfo(), object: ResultTipObserver<EyeRankTabInfo>(
            BaseApplication.instance) {
            override fun onSuccess(result: EyeRankTabInfo?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }
        })
    }

    fun getIssueData(url: String, resultCallBack: ResultCallBack<EyeIssueBean>?){
        val api = RetrofitEyeFactory.createService(RankService::class.java)
        RetrofitEyeFactory.executeResult(api.getIssueData(url),object: ResultTipObserver<EyeIssueBean>(
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