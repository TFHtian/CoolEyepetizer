package com.cooleyepetizer.app.repository.home

import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.common_lib.net.ResultTipObserver
import com.cooleyepetizer.app.common_lib.net.RetrofitEyeFactory
import com.cooleyepetizer.app.entity.eye_video.EyeItemResponse
import com.cooleyepetizer.app.entity.eye_video.EyeRankTabInfo
import com.cooleyepetizer.app.service.ThemeService

class ThemeRepository {

    fun getThemeTabInfo(resultCallBack: ResultCallBack<EyeRankTabInfo>?){
        val api = RetrofitEyeFactory.createService(ThemeService::class.java)
        RetrofitEyeFactory.executeResult(api.getThemeTabInfo(), object: ResultTipObserver<EyeRankTabInfo>(
            BaseApplication.instance) {
            override fun onSuccess(result: EyeRankTabInfo?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }
        })
    }

    fun getThemeListData(url: String, resultCallBack: ResultCallBack<EyeItemResponse>?){
        val api = RetrofitEyeFactory.createService(ThemeService::class.java)
        RetrofitEyeFactory.executeResult(api.getThemeListData(url),object: ResultTipObserver<EyeItemResponse>(
            BaseApplication.instance){
            override fun onSuccess(result: EyeItemResponse?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }

        })
    }

}