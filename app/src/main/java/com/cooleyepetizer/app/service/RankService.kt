package com.cooleyepetizer.app.service

import com.cooleyepetizer.app.common_lib.config.AppConfig
import com.cooleyepetizer.app.entity.eye_video.EyeIssueBean
import com.cooleyepetizer.app.entity.eye_video.EyeRankTabInfo
import com.cooleyepetizer.app.entity.eye_video.EyeVideoResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface RankService {

    /**
     * 获取rank tab信息和URL
     */
    @GET(AppConfig.RANK_TAB_INFO)
    fun getRankTabInfo(): Observable<Response<EyeRankTabInfo>>


    /**
     * 获取更多的 Issue
     */
    @GET
    fun getIssueData(@Url url: String): Observable<Response<EyeIssueBean>>
}