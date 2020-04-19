package com.cooleyepetizer.app.service

import com.cooleyepetizer.app.entity.eye_video.EyeVideoResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface HomeService {

    /**
     * 获取第一页数据
     */
    @GET("v2/feed?")
    fun getHomeFirstData(@Query("num") num:Int): Observable<Response<EyeVideoResponse>>

    /**
     * 根据 nextPageUrl 请求数据下一页数据
     */
    @GET
    fun getMoreHomeData(@Url url: String): Observable<Response<EyeVideoResponse>>

}