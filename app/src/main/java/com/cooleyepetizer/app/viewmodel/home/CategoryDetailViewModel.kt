package com.cooleyepetizer.app.viewmodel.home

import androidx.lifecycle.MutableLiveData
import com.cooleyepetizer.app.common_lib.mvvm.BaseRefreshViewModel
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.entity.eye_video.EyeItemResponse
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean
import com.cooleyepetizer.app.repository.home.HomeRepository
import com.cooleyepetizer.app.repository.recommend.CategoryRepository

class CategoryDetailViewModel : BaseRefreshViewModel(){

    var nextPageUrl = ""
    val categoryList = MutableLiveData<ArrayList<EyeListItemBean>>()

    fun getCategoryDetail(id: Long){
        setShowInitLoadView(true)
        CategoryRepository().getCategoryDetailData(id,object: ResultCallBack<EyeItemResponse> {
            override fun onSuccess(result: EyeItemResponse?) {
                setShowInitLoadView(false)
                nextPageUrl = result!!.nextPageUrl
                categoryList.value = result.itemList
            }

            override fun onFailure() {
                setShowInitLoadView(false)
            }
        })
    }

    /*获取更多列表数据*/
    private fun loadMoreData(url: String){
        HomeRepository().getHomeLoadMoreData(url, object: ResultCallBack<EyeItemResponse>{
            override fun onSuccess(result: EyeItemResponse?) {
                nextPageUrl = result!!.nextPageUrl
                categoryList.value = result?.itemList
                if (isLoadMore.get()!!) setEnableLoadMore(true) else setEnableRefresh(true)
            }
        })
    }

    override fun refreshData() {

    }

    override fun loadMoreData() {
        loadMoreData(nextPageUrl)
    }

}