package com.cooleyepetizer.app.fragment.home

import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmFragment
import com.cooleyepetizer.app.databinding.FragmentFindBinding
import com.cooleyepetizer.app.viewmodel.home.HomeViewModel

class FindFragment : BaseMvvmFragment<FragmentFindBinding, HomeViewModel>() {

    override fun initView() {
        isHideToolBar(true)
    }

    override fun initData() {
    }

    override fun onBindLayout(): Int {
        return R.layout.fragment_find
    }

    override fun onBindViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }
}