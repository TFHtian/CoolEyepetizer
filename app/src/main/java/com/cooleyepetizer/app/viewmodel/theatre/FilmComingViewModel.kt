package com.cooleyepetizer.app.viewmodel.theatre

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.mvvm.BaseRefreshViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.entity.film.FilmComingBean
import com.cooleyepetizer.app.entity.film.MoviecomingBean
import com.cooleyepetizer.app.repository.theatre.FilmComingRepository

class FilmComingViewModel : BaseRefreshViewModel(){

    private var locationId = 587
    val filmComingList = MutableLiveData<ArrayList<MoviecomingBean>>()

    fun getFilmComingData(){
        setShowInitLoadView(true)
        FilmComingRepository().getFilmComingData(locationId,object: ResultCallBack<FilmComingBean>{
            override fun onSuccess(result: FilmComingBean?) {
                setShowInitLoadView(false)
                filmComingList.value = result?.moviecomings
            }

            override fun onFailure() {
                setShowInitLoadView(false)
            }
        })
    }

    override fun refreshData() {

    }

    override fun loadMoreData() {

    }
}