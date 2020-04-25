package com.cooleyepetizer.app.service

import com.cooleyepetizer.app.common_lib.config.AppConfig
import com.cooleyepetizer.app.entity.eye_video.EyeIssueBean
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface FollowService {

    /**
     * 获取关注第一页数据
     */
    @GET(AppConfig.FOLLOW_VIDEO_LIST)
    fun getFollowFirstData(): Observable<Response<EyeIssueBean>>

    /**
     * 根据 nextPageUrl 请求数据下一页数据
     */
    @GET
    fun getMoreFollowData(@Url url: String): Observable<Response<EyeIssueBean>>

}