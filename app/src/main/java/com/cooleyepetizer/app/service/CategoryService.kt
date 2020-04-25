package com.cooleyepetizer.app.service

import com.cooleyepetizer.app.common_lib.config.AppConfig
import com.cooleyepetizer.app.entity.eye_video.EyeCategoryBean
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface CategoryService {

    @GET(AppConfig.CATEGORY_INFO)
    fun getCategory(): Observable<Response<ArrayList<EyeCategoryBean>>>
}