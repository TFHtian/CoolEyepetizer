package com.cooleyepetizer.app.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.Observer
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.cooleyepetizer.app.PlaceRepository
import com.google.gson.Gson


class PlaceViewModel : ViewModel() {

    fun getPlace(activity: AppCompatActivity) {
        PlaceRepository.getPlace()?.observe(activity, Observer {
            Log.e("gggggggg", Gson().toJson(it))
        })
    }

}