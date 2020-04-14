package com.cooleyepetizer.app.fragment

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmFragment
import com.cooleyepetizer.app.databinding.FragmentTestBinding
import com.cooleyepetizer.app.viewmodel.PlaceViewModel
import com.cooleyepetizer.lib.OnViewClickListener

class HomeFragment : BaseMvvmFragment<FragmentTestBinding, PlaceViewModel>() {

    override fun onBindLayout(): Int {
        return R.layout.fragment_test
    }

    override fun onBindViewModel(): Class<PlaceViewModel> {
        return PlaceViewModel::class.java
    }

    override fun initView() {
        setCenterTitle("首页")
    }

    override fun initData() {
        mBinding?.model = mViewModel
        mViewModel?.createUser()
        mViewModel?.getPlace(activity as AppCompatActivity)
        mBinding?.listener = object : OnViewClickListener {
            override fun onClick(v: View) {
                mViewModel?.updateName()
            }
        }
    }
}