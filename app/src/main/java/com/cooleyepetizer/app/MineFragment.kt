package com.cooleyepetizer.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cooleyepetizer.app.common_lib.mvvm.BaseFragment

class MineFragment  : BaseFragment() {

    override fun initView() {
        setCenterTitle("我的")
    }

    override fun initData() {
    }

    override fun onBindLayout(): Int {
        return R.layout.fragment_test
    }

    companion object {
        fun getInstance(title:String): MineFragment {
            val fragment = MineFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

}