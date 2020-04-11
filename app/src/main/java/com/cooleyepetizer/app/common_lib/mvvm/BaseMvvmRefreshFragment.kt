package com.cooleyepetizer.app.common_lib.mvvm

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.scwang.smartrefresh.layout.SmartRefreshLayout

abstract class BaseMvvmRefreshFragment<DB : ViewDataBinding,  VM : BaseRefreshViewModel> :BaseMvvmFragment<DB,VM>() {

    open lateinit var mRefreshLayout: SmartRefreshLayout

    override fun initContentView() {
        super.initContentView()
        initRefreshView()
    }

    override fun initBaseViewObservable() {
        super.initBaseViewObservable()
        initBaseViewRefreshObservable()
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
    }

    abstract fun getRefreshLayout(): SmartRefreshLayout

}