package com.cooleyepetizer.app.repository.recommend

import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.common_lib.net.ResultTipObserver
import com.cooleyepetizer.app.common_lib.net.RetrofitEyeFactory
import com.cooleyepetizer.app.entity.eye_video.EyeCategoryBean
import com.cooleyepetizer.app.service.CategoryService

class CategoryRepository {

    fun getCategory(resultCallBack: ResultCallBack<ArrayList<EyeCategoryBean>>){
        val api = RetrofitEyeFactory.createService(CategoryService::class.java)
        RetrofitEyeFactory.executeResult(api.getCategory(),object: ResultTipObserver<ArrayList<EyeCategoryBean>>(
        BaseApplication.instance){
            override fun onSuccess(result: ArrayList<EyeCategoryBean>?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }

        } )
    }
}