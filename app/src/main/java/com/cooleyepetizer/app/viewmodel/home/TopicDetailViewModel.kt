package com.cooleyepetizer.app.viewmodel.home

import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.mvvm.BaseViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.entity.eye_video.TopicDetailBean
import com.cooleyepetizer.app.repository.home.HomeRepository

class TopicDetailViewModel : BaseViewModel(){

    var detailBean = MutableLiveData<TopicDetailBean>()

    fun getTopicDetail(id: Long){
        setShowInitLoadView(true)
        HomeRepository().getTopicDetail(id, object: ResultCallBack<TopicDetailBean> {
            override fun onSuccess(result: TopicDetailBean?) {
                setShowInitLoadView(false)
                detailBean.value = result
            }

            override fun onFailure() {
                super.onFailure()
                setShowInitLoadView(false)
            }
        })
    }

}