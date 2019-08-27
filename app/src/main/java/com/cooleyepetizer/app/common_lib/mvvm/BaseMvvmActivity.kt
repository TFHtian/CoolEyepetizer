package com.cooleyepetizer.app.common_lib.mvvm

import android.util.Log
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer

abstract class BaseMvvmActivity<DB : ViewDataBinding,  VM : BaseViewModel> : BaseActivity() {

    private var mBinding: DB? = null
    private var mViewModel: VM? = null

    override fun initContentView() {
        super.initContentView()
        initViewDataBinding()
        initBaseViewObservable()
    }

    protected abstract fun initViewModel(): VM

    private fun initViewDataBinding() {
        val sonView = LayoutInflater.from(this).inflate(onBindLayout(),null)
        mBinding = DataBindingUtil.bind(sonView)
    }

    private fun initBaseViewObservable() {
        mViewModel?.getInitUI()?.observe(this, Observer {
            Log.e("iiiiiiii-----", it.toString())
            showInitLoadView(it)
        })
    }

}