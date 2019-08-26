package com.cooleyepetizer.app.common_lib.mvvm

import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer

abstract class BaseMvvmActivity<DB : ViewDataBinding,  VM : BaseViewModel> : BaseActivity() {

    private var mBinding: DB? = null
    private lateinit var mViewModel: VM

    override fun initContentView() {
        super.initContentView()
        initViewDataBinding()
    }

    private fun initViewDataBinding() {
        val sonView = LayoutInflater.from(this).inflate(onBindLayout(),null)
        mBinding = DataBindingUtil.bind(sonView)
    }

    protected fun initBaseViewObservable() {
        mViewModel.getUC().getShowNoDataViewEvent().observe(this, Observer {

        })
    }

}