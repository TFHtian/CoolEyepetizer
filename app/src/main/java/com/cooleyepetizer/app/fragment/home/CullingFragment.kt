package com.cooleyepetizer.app.fragment.home

import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.mvvm.BaseFragment
import com.cooleyepetizer.app.databinding.FragmentCullingBinding

class CullingFragment : BaseFragment<FragmentCullingBinding>() {

    override fun initView() {
        isHideToolBar(true)
    }

    override fun initData() {
    }

    override fun onBindLayout(): Int {
        return R.layout.fragment_culling
    }
}