package com.cooleyepetizer.app.repository.theatre

import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.common_lib.net.ResultTipObserver
import com.cooleyepetizer.app.common_lib.net.RetrofitFilmFactory
import com.cooleyepetizer.app.entity.film.FilmShowingBean
import com.cooleyepetizer.app.service.FilmShowingService

class FilmShowingRepository {

    fun getFilmShowingData(locationId:Int,resultCallBack: ResultCallBack<FilmShowingBean>?){
        val api = RetrofitFilmFactory.createService(FilmShowingService::class.java)
        RetrofitFilmFactory.executeResult(api.getFilmShowingData(locationId),object: ResultTipObserver<FilmShowingBean>(
        BaseApplication.instance){
            override fun onSuccess(result: FilmShowingBean?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }

        })
    }

}