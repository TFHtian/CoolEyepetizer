package com.cooleyepetizer.app.fragment.home

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.home.HomeListAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmRefreshFragment
import com.cooleyepetizer.app.databinding.FragmentHomeRecommendBinding
import com.cooleyepetizer.app.viewmodel.home.HomeRecommendViewModel
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.fragment_home_recommend.*

class HomeRecommendFragment : BaseMvvmRefreshFragment<FragmentHomeRecommendBinding, HomeRecommendViewModel>(){

    private val recommendAdapter by lazy { HomeListAdapter() }

    override fun onBindLayout(): Int {
        return R.layout.fragment_home_recommend
    }

    override fun onBindViewModel(): Class<HomeRecommendViewModel> {
        return HomeRecommendViewModel::class.java
    }

    override fun getRefreshLayout(): SmartRefreshLayout {
        return refresh_layout
    }

    override fun initView() {
        isHideToolBar(true)
        recommend_list.adapter = recommendAdapter
        recommend_list.layoutManager = LinearLayoutManager(activity)
    }

    override fun initData() {
        mViewModel?.getHomeRecommendData()
        mViewModel?.recommendList?.observe(this, Observer {
            if (mViewModel?.isLoadMore?.get()!!){
                recommendAdapter?.addData(it)
            }else{
                recommendAdapter?.setList(it)
            }
        })
    }

    override fun loadDataByRefresh() {
        mViewModel?.refresh()
    }

    override fun loadDataByLoadMore() {
        mViewModel?.loadMore()
    }

}