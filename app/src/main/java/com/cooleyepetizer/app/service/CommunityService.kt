package com.cooleyepetizer.app.service

import com.cooleyepetizer.app.common_lib.config.AppConfig
import com.cooleyepetizer.app.entity.eye_video.EyeItemResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface CommunityService {

    /**
     * 获取社区推荐数据
     */
    @GET(AppConfig.Get_Community_Recommend_Data)
    fun getCommunityRecommendData(): Observable<Response<EyeItemResponse>>

    /**
     * 获取社区推荐数据
     */
    @GET(AppConfig.Get_Community_Follow_Data)
    fun getCommunityFollowData(): Observable<Response<EyeItemResponse>>
}