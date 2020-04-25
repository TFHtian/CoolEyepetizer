package com.cooleyepetizer.app.viewmodel.recommend

import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.mvvm.BaseViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.entity.eye_video.EyeCategoryBean
import com.cooleyepetizer.app.repository.recommend.CategoryRepository

class CategoryViewModel : BaseViewModel(){

    val categoryList = MutableLiveData<ArrayList<EyeCategoryBean>>()

    fun getCategory(){
        setShowInitLoadView(true)
        CategoryRepository().getCategory(object: ResultCallBack<ArrayList<EyeCategoryBean>>{
            override fun onSuccess(result: ArrayList<EyeCategoryBean>?) {
                setShowInitLoadView(false)
                categoryList.value = result
            }

            override fun onFailure() {
                setShowInitLoadView(false)
            }
        })
    }

}