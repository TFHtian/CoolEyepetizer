package com.cooleyepetizer.app.common_lib.mvvm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import org.jetbrains.anko.runOnUiThread

/**
 * 基类列表VM
 */
abstract class BaseViewModel(private val application: Application) : ViewModel(), ResultCallBack<ArrayList<Any>> {

    val dataList = MutableLiveData<ArrayList<Any>>()


    open fun commitResult(result: ArrayList<Any>?) {
        result?.apply {
            dataList.value = result
        }
    }

    override fun onSuccess(result: ArrayList<Any>?) {
        commitResult(result)
    }

    override fun onCacheSuccess(result: ArrayList<Any>?) {
        application.runOnUiThread {
            result?.apply {
                if (this.isNotEmpty()) {
                    commitResult(result)
                }
            }
        }
    }

    override fun onFailure() {

    }


}