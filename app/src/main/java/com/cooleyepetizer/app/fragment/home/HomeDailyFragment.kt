package com.cooleyepetizer.app.fragment.home

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.home.HomeFindAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmRefreshFragment
import com.cooleyepetizer.app.databinding.FragmentHomeDailyBinding
import com.cooleyepetizer.app.viewmodel.home.HomeDailyViewModel
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.fragment_home_daily.*
import kotlinx.android.synthetic.main.fragment_home_daily.refresh_layout

class HomeDailyFragment : BaseMvvmRefreshFragment<FragmentHomeDailyBinding, HomeDailyViewModel>(){

    private val findAdapter by lazy { HomeFindAdapter() }

    override fun onBindViewModel(): Class<HomeDailyViewModel> {
        return HomeDailyViewModel::class.java
    }

    override fun onBindLayout(): Int {
        return R.layout.fragment_home_daily
    }

    override fun getRefreshLayout(): SmartRefreshLayout {
        return refresh_layout
    }

    override fun initView() {
        isHideToolBar(true)
        daily_list.adapter = findAdapter
        daily_list.layoutManager = LinearLayoutManager(activity)
    }

    override fun initData() {
        mViewModel?.getHomeDailyData()
        mViewModel?.dailyList?.observe(this, Observer {
            if (mViewModel?.isLoadMore?.get()!!){
                findAdapter?.addData(it)
            }else{
                findAdapter?.setList(it)
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