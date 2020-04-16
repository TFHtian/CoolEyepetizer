package com.cooleyepetizer.app.repository.place

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.common_lib.net.ResultTipObserver
import com.cooleyepetizer.app.common_lib.net.RetrofitFactory
import com.cooleyepetizer.app.entity.place.Province
import com.cooleyepetizer.app.service.PlaceService
import java.util.ArrayList

class PlaceRepository {

    fun getPlace() : LiveData<ArrayList<Province>?> {

        val api = RetrofitFactory.createService(PlaceService::class.java)
        val liveData = MutableLiveData<ArrayList<Province>?>()
        RetrofitFactory.executeResult(api.getProvinces(), object: ResultTipObserver<ArrayList<Province>>(
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
        val api = RetrofitFactory.createService(PlaceService::class.java)
        RetrofitFactory.executeResult(api.getProvinces(), object: ResultTipObserver<ArrayList<Province>>(BaseApplication.instance) {
            override fun onSuccess(result: ArrayList<Province>?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }
        })
    }

}