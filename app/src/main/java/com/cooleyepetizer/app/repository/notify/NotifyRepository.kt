package com.cooleyepetizer.app.repository.notify

import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.common_lib.net.ResultTipObserver
import com.cooleyepetizer.app.common_lib.net.RetrofitEyeFactory
import com.cooleyepetizer.app.entity.notify.NotifyInteractBean
import com.cooleyepetizer.app.entity.notify.NotifyPushBean
import com.cooleyepetizer.app.service.NotifyService

class NotifyRepository {

    fun getNotifyPushData(resultCallBack: ResultCallBack<NotifyPushBean>?){
        val api = RetrofitEyeFactory.createService(NotifyService::class.java)
        RetrofitEyeFactory.executeResult(api.getNotifyPushData(),object:
            ResultTipObserver<NotifyPushBean>(BaseApplication.instance){
            override fun onSuccess(result: NotifyPushBean?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }
        })
    }

    fun getMoreNotifyPushData(url: String,resultCallBack: ResultCallBack<NotifyPushBean>?){
        val api = RetrofitEyeFactory.createService(NotifyService::class.java)
        RetrofitEyeFactory.executeResult(api.getMoreNotifyPushData(url),object:
            ResultTipObserver<NotifyPushBean>(BaseApplication.instance){
            override fun onSuccess(result: NotifyPushBean?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }
        })
    }

    fun getNotifyInteractData(resultCallBack: ResultCallBack<NotifyInteractBean>?){
        val api = RetrofitEyeFactory.createService(NotifyService::class.java)
        RetrofitEyeFactory.executeResult(api.getNotifyInteractData(),object:
            ResultTipObserver<NotifyInteractBean>(BaseApplication.instance){
            override fun onSuccess(result: NotifyInteractBean?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }
        })
    }

    fun getMoreNotifyInteractData(url: String,resultCallBack: ResultCallBack<NotifyInteractBean>?){
        val api = RetrofitEyeFactory.createService(NotifyService::class.java)
        RetrofitEyeFactory.executeResult(api.getMoreNotifyInteractData(url),object:
            ResultTipObserver<NotifyInteractBean>(BaseApplication.instance){
            override fun onSuccess(result: NotifyInteractBean?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }
        })
    }


}