package com.cooleyepetizer.app.viewmodel

import android.util.Log
import androidx.lifecycle.Observer
import androidx.appcompat.app.AppCompatActivity
import com.cooleyepetizer.app.PlaceRepository
import com.cooleyepetizer.app.common_lib.mvvm.BaseViewModel
import com.google.gson.Gson


class PlaceViewModel : BaseViewModel() {

    fun getPlace(activity: AppCompatActivity) {
        postShowInitLoadView(true)
        PlaceRepository(activity).getPlace()?.observe(activity, Observer {
            Log.e("gggggggg", Gson().toJson(it))
        })
    }

}