package com.cooleyepetizer.app

import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmActivity
import com.cooleyepetizer.app.databinding.ActivityTextMvvmBinding
import com.cooleyepetizer.app.viewmodel.PlaceViewModel

class TextActivity : BaseMvvmActivity<ActivityTextMvvmBinding,PlaceViewModel>() {

    override fun initViewModel(): PlaceViewModel {
        Log.e("Test", "艹，没走到，封装的啥鸡8")
        return ViewModelProviders.of(this)[PlaceViewModel::class.java]
    }

    override fun onBindLayout(): Int {
        return R.layout.activity_text_mvvm
    }

    override fun onInit() {
        setCenterTitle("测试")
        mViewModel?.getPlace(this)
    }

    override fun initView() {
    }

    override fun initData() {

    }

}