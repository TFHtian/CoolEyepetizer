package com.cooleyepetizer.app.fragment

import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.mvvm.BaseFragment
import com.cooleyepetizer.app.databinding.FragmentRecommendBinding

class RecommendFragment : BaseFragment<FragmentRecommendBinding>(){

    override fun onBindLayout(): Int {
        return R.layout.fragment_recommend
    }

    override fun initView() {

    }

    override fun initData() {
    }

}