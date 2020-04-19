package com.cooleyepetizer.app.fragment.recommend

import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.mvvm.BaseFragment
import com.cooleyepetizer.app.databinding.FragmentCategoryBinding

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(){

    override fun onBindLayout(): Int {
        return R.layout.fragment_category
    }

    override fun initView() {
        isHideToolBar(true)
    }

    override fun initData() {
    }
}