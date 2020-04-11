package com.cooleyepetizer.app.fragment

import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.mvvm.BaseFragment

class FindFragment : BaseFragment() {

    override fun initView() {
        setCenterTitle("发现")
    }

    override fun initData() {
    }

    override fun onBindLayout(): Int {
        return R.layout.fragment_test
    }
}