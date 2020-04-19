package com.cooleyepetizer.app.fragment.home

import android.util.Log
import androidx.lifecycle.Observer
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmRefreshFragment
import com.cooleyepetizer.app.databinding.FragmentCullingBinding
import com.cooleyepetizer.app.viewmodel.home.HomeViewModel
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.fragment_culling.*

class CullingFragment : BaseMvvmRefreshFragment<FragmentCullingBinding,HomeViewModel>() {

    override fun initView() {
        isHideToolBar(true)
    }

    override fun initData() {
        mViewModel?.getHomeFirstData()
        mViewModel?.dataList?.observe(this, Observer {
            when(mViewModel?.isLoadMore?.get()){
                false -> Log.e("yyyyyy","第一次加载和刷新")
                true -> Log.e("yyyyyy","上拉加载更多")
            }
        })
        mViewModel?.bannerList?.observe(this, Observer {
            Log.e("uuuuu","${it.size}")
        })
    }

    override fun onBindLayout(): Int {
        return R.layout.fragment_culling
    }

    override fun getRefreshLayout(): SmartRefreshLayout {
        return refresh_layout
    }

    override fun onBindViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun loadDataByRefresh() {
        mViewModel?.refresh()
    }

    override fun loadDataByLoadMore() {
        mViewModel?.loadMore()
    }

}