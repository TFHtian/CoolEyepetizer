package com.cooleyepetizer.app.viewmodel.home

import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.mvvm.BaseViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.entity.eye_video.CategoryBean
import com.cooleyepetizer.app.entity.eye_video.EyeItemResponse
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean
import com.cooleyepetizer.app.repository.recommend.CategoryRepository

class CategoryViewModel : BaseViewModel(){

    val categoryList = MutableLiveData<ArrayList<CategoryBean>>()

    fun getCategoryList(){
        setShowInitLoadView(true)
        CategoryRepository().getCategoryListData(object: ResultCallBack<ArrayList<CategoryBean>>{
            override fun onSuccess(result: ArrayList<CategoryBean>?) {
                setShowInitLoadView(false)
                categoryList.value = result
            }

            override fun onFailure() {
                setShowInitLoadView(false)
            }
        })
    }

}