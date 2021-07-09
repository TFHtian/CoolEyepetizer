package com.cooleyepetizer.app.common_lib.mvvm

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener

abstract class BaseMvvmRefreshActivity<DB : ViewDataBinding,  VM : BaseRefreshViewModel> :BaseMvvmActivity<DB,VM>()
                    , OnRefreshListener, OnLoadMoreListener {

    open lateinit var mRefreshLayout: SmartRefreshLayout

    override fun initContentView() {
        super.initContentView()
        initRefreshView()
    }

    override fun initBaseViewObservable() {
        super.initBaseViewObservable()
        initBaseViewRefreshObservable();
    }

    private fun initBaseViewRefreshObservable(){
        mViewModel?.enableRefresh?.observe(this, Observer {
            mRefreshLayout.finishRefresh()
        })
        mViewModel?.enableLoadMore?.observe(this, Observer {
            mRefreshLayout.finishLoadMore()
        })
    }

    private fun initRefreshView() {
        mRefreshLayout = getRefreshLayout()
        mRefreshLayout.setOnRefreshListener(this)
        mRefreshLayout.setOnLoadMoreListener(this)
    }

    abstract fun getRefreshLayout(): SmartRefreshLayout

    override fun onRefresh(refreshLayout: RefreshLayout) {
        loadDataByRefresh()
    }

    override fun onLoadMore(refreshLayout: RefreshLayout) {
        loadDataByLoadMore()
    }

    abstract fun loadDataByRefresh()

    abstract fun loadDataByLoadMore()

}