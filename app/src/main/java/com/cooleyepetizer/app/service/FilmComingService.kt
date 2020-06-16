package com.cooleyepetizer.app.service

import com.cooleyepetizer.app.common_lib.config.AppConfig
import com.cooleyepetizer.app.entity.film.FilmComingBean
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmComingService {

    @GET(AppConfig.Get_Film_Coming_Data)
    fun getFilmComingData(@Query("locationId") locationId:Int): Observable<Response<FilmComingBean>>
}