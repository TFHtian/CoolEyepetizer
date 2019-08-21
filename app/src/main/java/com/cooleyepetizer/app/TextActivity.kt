package com.cooleyepetizer.app

import androidx.lifecycle.ViewModelProviders
import com.cooleyepetizer.app.common_lib.mvvm.BaseActivity
import com.cooleyepetizer.app.databinding.ActivityTextMvvmBinding
import com.cooleyepetizer.app.viewmodel.PlaceViewModel

class TextActivity : BaseActivity() {

    private var mBinding: ActivityTextMvvmBinding? = null
    private var viewModel : PlaceViewModel? = null

    override fun onBindLayout(): Int {
        return R.layout.activity_text_mvvm
    }

    override fun initView() {
        viewModel = ViewModelProviders.of(this)[PlaceViewModel::class.java]
        setCenterTitle("测试")
        viewModel?.getPlace(this)
//        showInitLoadView(true)
//        mBinding = DataBindingUtil.bind(ll_test)
//        mBinding = DataBindingUtil.setContentView<ActivityTextMvvmBinding>(this, R.layout.activity_text_mvvm)
    }

    override fun initData() {

    }

}