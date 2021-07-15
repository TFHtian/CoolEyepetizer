package com.cooleyepetizer.app.fragment

import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.mvvm.BaseFragment
import com.cooleyepetizer.app.databinding.FragmentMineBinding
import com.gyf.immersionbar.ImmersionBar
import kotlinx.android.synthetic.main.common_toolbar.*

class MineFragment  : BaseFragment<FragmentMineBinding>() {

    override fun initView() {
        isHideToolBar(true)
    }

    override fun initData() {
    }

    override fun onBindLayout(): Int {
        return R.layout.fragment_mine
    }
}