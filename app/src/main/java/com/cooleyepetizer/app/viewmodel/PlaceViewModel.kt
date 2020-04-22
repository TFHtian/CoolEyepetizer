package com.cooleyepetizer.app.viewmodel

import androidx.lifecycle.Observer
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ObservableField
import com.cooleyepetizer.app.repository.place.PlaceRepository
import com.cooleyepetizer.app.common_lib.mvvm.BaseViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.entity.place.Province
import com.cooleyepetizer.app.entity.place.User
class PlaceViewModel : BaseViewModel() {

    val user = ObservableField<User>()

    fun createUser(){
        user?.set(User("甜甜","女","http://img.kaiyanapp.com/64f2b2ed039bd92c3be10d003d6041bf.jpeg?imageMogr2/quality/60/format/jpg"))
    }

    fun updateName(){
        user?.set(User("灰灰","女","http://img.kaiyanapp.com/64f2b2ed039bd92c3be10d003d6041bf.jpeg?imageMogr2/quality/60/format/jpg"))
    }

    fun getPlace(activity: AppCompatActivity) {
        setShowInitLoadView(true)
        PlaceRepository().getPlace()?.observe(activity, Observer {
            setShowInitLoadView(false)
        })
    }

    fun getCallBackPlace(){
        PlaceRepository().getCallBackPlace(object : ResultCallBack<ArrayList<Province>> {
            override fun onSuccess(result: ArrayList<Province>?) {

            }

            override fun onFailure() {
                super.onFailure()
            }
        })
    }

}