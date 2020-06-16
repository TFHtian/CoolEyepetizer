package com.cooleyepetizer.app.service

import com.cooleyepetizer.app.common_lib.config.AppConfig
import com.cooleyepetizer.app.entity.film.FilmShowingBean
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmShowingService {

    @GET(AppConfig.Get_Film_Showing_Data)
    fun getFilmShowingData(@Query("locationId") locationId:Int): Observable<Response<FilmShowingBean>>
}