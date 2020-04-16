package com.cooleyepetizer.app.viewmodel

import android.util.Log
import androidx.lifecycle.Observer
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.repository.place.PlaceRepository
import com.cooleyepetizer.app.common_lib.mvvm.BaseViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.entity.place.Province
import com.cooleyepetizer.app.entity.place.User
import com.google.gson.Gson

class PlaceViewModel : BaseViewModel() {

    val user = ObservableField<User>()
    fun createUser(){
        user?.set(User("甜甜","女"))
    }

    fun updateName(){
        user?.set(User("灰灰","女"))
    }

    fun getPlace(activity: AppCompatActivity) {
        setShowInitLoadView(true)
        PlaceRepository().getPlace()?.observe(activity, Observer {
            Log.e("gggggggg", Gson().toJson(it))
            setShowInitLoadView(false)
        })
    }

    fun getCallBackPlace(){
        PlaceRepository().getCallBackPlace(object : ResultCallBack<ArrayList<Province>> {
            override fun onSuccess(result: ArrayList<Province>?) {
                Log.e("sssssss", Gson().toJson(result))
            }

            override fun onFailure() {
                super.onFailure()
            }
        })

    }

}