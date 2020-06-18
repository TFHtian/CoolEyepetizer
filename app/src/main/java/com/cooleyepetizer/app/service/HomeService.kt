package com.cooleyepetizer.app.service

import com.cooleyepetizer.app.common_lib.config.AppConfig
import com.cooleyepetizer.app.entity.eye_video.EyeIssueBean
import com.cooleyepetizer.app.entity.eye_video.EyeItemResponse
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
    @GET(AppConfig.HOME_VIDEO_LIST)
    fun getHomeFirstData(@Query("num") num:Int): Observable<Response<EyeVideoResponse>>

    /**
     * 根据 nextPageUrl 请求数据下一页数据
     */
    @GET
    fun getMoreHomeData(@Url url: String): Observable<Response<EyeVideoResponse>>

    /**
     * 获取首页推荐数据
     */
    @GET(AppConfig.Get_Home_Recommend_Data)
    fun getHomeRecommendData(): Observable<Response<EyeItemResponse>>

    /**
     * 获取首页发现数据
     */
    @GET(AppConfig.Get_Home_Find_Data)
    fun getHomeFindData(): Observable<Response<EyeItemResponse>>

    /**
     * 获取首页发现数据
     */
    @GET(AppConfig.Get_Home_Daily_Data)
    fun getHomeDailyData(): Observable<Response<EyeItemResponse>>

    /**
     * 根据 nextPageUrl 请求数据下一页数据
     */
    @GET
    fun getHomeLoadMoreData(@Url url: String): Observable<Response<EyeItemResponse>>

    /**
     *获取分类列表
     */
    @GET(AppConfig.CATEGORY_INFO)
    fun getCategoryListData(): Observable<Response<EyeItemResponse>>

}