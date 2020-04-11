package com.cooleyepetizer.app.fragment

import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.mvvm.BaseFragment

class CullingFragment : BaseFragment() {

    override fun initView() {
        setCenterTitle("精选")
    }

    override fun initData() {
    }

    override fun onBindLayout(): Int {
        return R.layout.fragment_test
    }
}