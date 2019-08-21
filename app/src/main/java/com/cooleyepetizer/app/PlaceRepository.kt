package com.cooleyepetizer.app

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.net.ResultProgressObserver
import com.cooleyepetizer.app.common_lib.net.RetrofitFactory
import com.cooleyepetizer.app.service.PlaceService
import java.util.ArrayList

class PlaceRepository( private val context: Context) {

    fun getPlace() : LiveData<ArrayList<Province>?> {

        val api = RetrofitFactory.createService(PlaceService::class.java)
        val liveData = MutableLiveData<ArrayList<Province>?>()
        RetrofitFactory.executeResult(api.getProvinces(), object: ResultProgressObserver<ArrayList<Province>>(context) {
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