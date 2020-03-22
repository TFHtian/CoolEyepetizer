package com.cooleyepetizer.app.viewmodel

import android.os.Handler
import android.util.Log
import androidx.lifecycle.Observer
import androidx.appcompat.app.AppCompatActivity
import com.cooleyepetizer.app.PlaceRepository
import com.cooleyepetizer.app.common_lib.mvvm.BaseViewModel
import com.google.gson.Gson


class PlaceViewModel : BaseViewModel() {


    private var count = 0

    fun getPlace(activity: AppCompatActivity) {

        setAbsLiveDataValue(true)
        loop()
    }

    private fun loop() {
        count ++
        Handler().postDelayed({
            setAbsLiveDataValue((Math.random() * 10).toInt() % 2 == 0)
            if (count < 10) {
                loop()
            }
        }, 3000)
    }

}