package com.cooleyepetizer.app.common_lib.mvvm

import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

abstract class BaseMvvmActivity<DB : ViewDataBinding,  VM : BaseViewModel> : BaseActivity() {

    var mBinding: DB? = null
    var mViewModel: VM? = null

    override fun initContentView() {
        super.initContentView()
        initViewDataBinding()
        initBaseViewObservable()
    }

    private fun initViewDataBinding() {
        val sonView = LayoutInflater.from(this).inflate(onBindLayout(),null)
        mBinding = DataBindingUtil.bind(sonView)
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

    override fun initListener() {}

}