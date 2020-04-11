package com.cooleyepetizer.app.viewmodel

import android.util.Log
import androidx.lifecycle.Observer
import androidx.appcompat.app.AppCompatActivity
import com.cooleyepetizer.app.repository.place.PlaceRepository
import com.cooleyepetizer.app.common_lib.mvvm.BaseViewModel
import com.cooleyepetizer.app.entity.place.User
import com.google.gson.Gson

class PlaceViewModel : BaseViewModel() {

    val name: String = "haha"

    var user: User? = null

    fun createUser(){
        user = User("甜甜","女")
    }

    fun updateName(){
        user?.name = "灰灰"
        Log.e("ccccc", user?.name)
    }

    fun getPlace(activity: AppCompatActivity) {
        setShowInitLoadView(true)
        PlaceRepository(activity).getPlace()?.observe(activity, Observer {
            Log.e("gggggggg", Gson().toJson(it))
            setShowInitLoadView(false)
        })
        setShowInitLoadView(false)
    }

}