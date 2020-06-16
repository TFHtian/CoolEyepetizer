package com.cooleyepetizer.app.service

import com.cooleyepetizer.app.common_lib.config.AppConfig
import com.cooleyepetizer.app.entity.notify.NotifyInteractBean
import com.cooleyepetizer.app.entity.notify.NotifyPushBean
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface NotifyService {

    /**
     * 获取通知推送数据
     */
    @GET(AppConfig.Get_Notify_Push_Data)
    fun getNotifyPushData(): Observable<Response<NotifyPushBean>>

    /**
     * 获取通知互动数据
     */
    @GET(AppConfig.Get_Notify_Interact_Data)
    fun getNotifyInteractData(): Observable<Response<NotifyInteractBean>>

}