package com.cooleyepetizer.app.viewmodel.theatre

import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.mvvm.BaseRefreshViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.entity.film.FilmShowingBean
import com.cooleyepetizer.app.entity.film.ShowingM
import com.cooleyepetizer.app.repository.theatre.FilmShowingRepository

class FilmShowingViewModel : BaseRefreshViewModel(){

    private var locationId = 587
    val filmShowingList = MutableLiveData<ArrayList<ShowingM>>()

    fun getFilmShowingData(){
        setShowInitLoadView(true)
        FilmShowingRepository().getFilmShowingData(locationId,object: ResultCallBack<FilmShowingBean>{
            override fun onSuccess(result: FilmShowingBean?) {
                setShowInitLoadView(false)
                filmShowingList.value = result?.ms
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