package com.cooleyepetizer.app.common_lib.mvvm

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

abstract class BaseMvvmFragment<DB : ViewDataBinding,  VM : BaseViewModel> : BaseFragment<DB>() {

    protected var mViewModel: VM? = null

    override fun initContentView() {
        super.initContentView()
        initViewModel()
        initBaseViewObservable()
    }

    private fun initViewModel() {
        mViewModel = createViewModel()
    }

    private fun createViewModel(): VM {
        return ViewModelProviders.of(this).get(onBindViewModel())
    }

    abstract fun onBindViewModel(): Class<VM>

    open fun initBaseViewObservable() {

        mViewModel?.showInitLoadView?.observe(this, Observer {
            showInitLoadView(it)
        })

        mViewModel?.showTransLoadingView?.observe(this, Observer {
            showTransLoadingView(it)
        })

        mViewModel?.showNoDataView?.observe(this, Observer {
            showNoDataView(it)
        })

        mViewModel?.showNetWorkErrView?.observe(this, Observer {
            showNetWorkErrView(it)
        })
    }

    override fun initView() {}

    override fun initData() {}

}