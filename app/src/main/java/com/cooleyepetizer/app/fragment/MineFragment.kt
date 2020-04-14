package com.cooleyepetizer.app.fragment

import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.mvvm.BaseFragment
import com.cooleyepetizer.app.databinding.FragmentTestBinding

class MineFragment  : BaseFragment<FragmentTestBinding>() {

    override fun initView() {
        setCenterTitle("我的")
    }

    override fun initData() {
    }

    override fun onBindLayout(): Int {
        return R.layout.fragment_test
    }
}