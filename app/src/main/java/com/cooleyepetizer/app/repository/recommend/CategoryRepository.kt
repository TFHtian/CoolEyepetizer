package com.cooleyepetizer.app.repository.recommend

import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.common_lib.net.ResultTipObserver
import com.cooleyepetizer.app.common_lib.net.RetrofitEyeFactory
import com.cooleyepetizer.app.entity.eye_video.CategoryBean
import com.cooleyepetizer.app.entity.eye_video.EyeItemResponse
import com.cooleyepetizer.app.service.HomeService

class CategoryRepository {

    fun getCategoryListData(resultCallBack: ResultCallBack<ArrayList<CategoryBean>>){
        val api = RetrofitEyeFactory.createService(HomeService::class.java)
        RetrofitEyeFactory.executeResult(api.getCategoryList(),object: ResultTipObserver<ArrayList<CategoryBean>>(
        BaseApplication.instance){
            override fun onSuccess(result: ArrayList<CategoryBean>?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }
        } )
    }

    fun getCategoryDetailData(id: Long,resultCallBack: ResultCallBack<EyeItemResponse>){
        val api = RetrofitEyeFactory.createService(HomeService::class.java)
        RetrofitEyeFactory.executeResult(api.getCategoryDetailData(id),object: ResultTipObserver<EyeItemResponse>(
            BaseApplication.instance){
            override fun onSuccess(result: EyeItemResponse?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }
        } )
    }

}