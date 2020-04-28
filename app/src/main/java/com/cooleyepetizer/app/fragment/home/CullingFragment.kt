package com.cooleyepetizer.app.fragment.home

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.home.CullingVideoAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmRefreshFragment
import com.cooleyepetizer.app.databinding.FragmentCullingBinding
import com.cooleyepetizer.app.view.CustomHeader
import com.cooleyepetizer.app.viewmodel.home.HomeViewModel
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.fragment_culling.*

class CullingFragment : BaseMvvmRefreshFragment<FragmentCullingBinding,HomeViewModel>() {

    private val cullAdapter by lazy { activity?.let { CullingVideoAdapter() } }

    override fun initView() {
        isHideToolBar(true)
        home_list.adapter = cullAdapter
        home_list.layoutManager = LinearLayoutManager(activity)
        //refresh_layout.setRefreshHeader(CustomHeader(mActivity))
        //refresh_layout.setHeaderHeight(60f)
    }

    override fun initData() {
        mViewModel?.getHomeFirstData()
        mViewModel?.dataList?.observe(this, Observer {
            if (mViewModel?.isLoadMore?.get()!!){
                cullAdapter?.addData(it)
            }else{
                cullAdapter?.setList(it)
            }
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