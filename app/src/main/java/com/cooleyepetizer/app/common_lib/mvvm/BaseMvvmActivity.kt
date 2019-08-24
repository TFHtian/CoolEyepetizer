package com.cooleyepetizer.app.common_lib.mvvm

import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseMvvmActivity<DB : ViewDataBinding> : BaseActivity() {

    private var mBinding: DB? = null

    override fun initContentView() {
        super.initContentView()
        initViewDataBinding()
    }

    private fun initViewDataBinding() {
        val sonView = LayoutInflater.from(this).inflate(onBindLayout(),null)
        mBinding = DataBindingUtil.bind(sonView)
    }

}