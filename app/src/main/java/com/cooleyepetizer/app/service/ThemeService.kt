package com.cooleyepetizer.app.service

import com.cooleyepetizer.app.common_lib.config.AppConfig
import com.cooleyepetizer.app.entity.eye_video.EyeItemResponse
import com.cooleyepetizer.app.entity.eye_video.EyeRankTabInfo
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ThemeService {

    /**
     * theme tab信息和URL
     */
    @GET(AppConfig.Theme_Tab_Info)
    fun getThemeTabInfo(): Observable<Response<EyeRankTabInfo>>

    /**
     * 获取theme列表数据
     */
    @GET
    fun getThemeListData(@Url url: String): Observable<Response<EyeItemResponse>>

}