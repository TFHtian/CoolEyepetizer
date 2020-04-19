package com.cooleyepetizer.app.repository.place

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.common_lib.net.ResultTipObserver
import com.cooleyepetizer.app.common_lib.net.RetrofitEyeFactory
import com.cooleyepetizer.app.entity.place.Province
import com.cooleyepetizer.app.service.PlaceService
import java.util.ArrayList

class PlaceRepository {

    fun getPlace() : LiveData<ArrayList<Province>?> {

        val api = RetrofitEyeFactory.createService(PlaceService::class.java)
        val liveData = MutableLiveData<ArrayList<Province>?>()
        RetrofitEyeFactory.executeResult(api.getProvinces(), object: ResultTipObserver<ArrayList<Province>>(
            BaseApplication.instance) {
            override fun onSuccess(result: ArrayList<Province>?) {
                liveData.value = result
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                liveData.value = null
            }
        })

        return liveData
    }

    fun  getCallBackPlace(resultCallBack: ResultCallBack<ArrayList<Province>>?){
        val api = RetrofitEyeFactory.createService(PlaceService::class.java)
        RetrofitEyeFactory.executeResult(api.getProvinces(), object: ResultTipObserver<ArrayList<Province>>(BaseApplication.instance) {
            override fun onSuccess(result: ArrayList<Province>?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }
        })
    }

}