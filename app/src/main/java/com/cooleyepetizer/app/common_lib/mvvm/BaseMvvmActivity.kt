package com.cooleyepetizer.app.common_lib.mvvm

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseMvvmActivity<V : ViewDataBinding> : BaseActivity() {

    private var mBinding: V? = null

    private fun initViewDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, onBindLayout())
    }

}