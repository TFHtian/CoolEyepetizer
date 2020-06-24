package com.cooleyepetizer.app.service

import com.cooleyepetizer.app.common_lib.config.AppConfig
import com.cooleyepetizer.app.entity.eye_video.EyeItemResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoPlayService {

    @GET(AppConfig.Get_Video_Detail)
    fun getVideoDetail(@Query("id") id: Long): Observable<Response<EyeItemResponse>>
}