package com.cooleyepetizer.app.repository.theatre

import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.common_lib.net.ResultTipObserver
import com.cooleyepetizer.app.common_lib.net.RetrofitFilmFactory
import com.cooleyepetizer.app.entity.film.FilmComingBean
import com.cooleyepetizer.app.service.FilmComingService

class FilmComingRepository {

    fun getFilmComingData(locationId:Int,resultCallBack: ResultCallBack<FilmComingBean>?){
        val api = RetrofitFilmFactory.createService(FilmComingService::class.java)
        RetrofitFilmFactory.executeResult(api.getFilmComingData(locationId),object: ResultTipObserver<FilmComingBean>(
        BaseApplication.instance){
            override fun onSuccess(result: FilmComingBean?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }
        })
    }
}