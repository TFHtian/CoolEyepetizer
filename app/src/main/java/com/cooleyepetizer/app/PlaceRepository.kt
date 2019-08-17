package com.cooleyepetizer.app

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.common_lib.net.ResultObserver
import com.cooleyepetizer.app.common_lib.net.RetrofitFactory
import com.cooleyepetizer.app.service.PlaceService
import java.util.ArrayList

object PlaceRepository {

    fun getPlace() : LiveData<ArrayList<Province>?> {

        val api = RetrofitFactory.createService(PlaceService::class.java)
        val liveData = MutableLiveData<ArrayList<Province>?>()
        RetrofitFactory.executeResult(api.getProvinces(), object: ResultObserver<ArrayList<Province>>() {
            override fun onSuccess(result: ArrayList<Province>?) {
                liveData.value = result
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                liveData.value = null
            }
        })

        return liveData
    }

}