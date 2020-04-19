package com.cooleyepetizer.app.service

import com.cooleyepetizer.app.entity.place.Province
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*
import java.util.ArrayList

interface PlaceService {

    @GET("api/china")
    fun getProvinces(): Observable<Response<ArrayList<Province>>>

}