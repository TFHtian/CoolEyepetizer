package com.cooleyepetizer.app.activity.place

import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmActivity
import com.cooleyepetizer.app.databinding.ActivityTextMvvmBinding
import com.cooleyepetizer.app.entity.place.User
import com.cooleyepetizer.app.viewmodel.PlaceViewModel

class PlaceTextActivity : BaseMvvmActivity<ActivityTextMvvmBinding,PlaceViewModel>() {

    override fun onBindViewModel(): Class<PlaceViewModel> {
        return PlaceViewModel::class.java
    }

    override fun onBindLayout(): Int {
        return R.layout.activity_text_mvvm
    }

    override fun initView() {
        setCenterTitle("测试")

    }

    override fun initData() {

        mViewModel?.getPlace(this)
        mViewModel?.createUser()
        var user = User("甜甜","女")
        mBinding?.u = user
    }

}