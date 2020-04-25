package com.cooleyepetizer.app.fragment.recommend

import androidx.lifecycle.Observer
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmFragment
import com.cooleyepetizer.app.databinding.FragmentCategoryBinding
import com.cooleyepetizer.app.viewmodel.recommend.CategoryViewModel

class CategoryFragment : BaseMvvmFragment<FragmentCategoryBinding, CategoryViewModel>(){

    override fun onBindLayout(): Int {
        return R.layout.fragment_category
    }

    override fun onBindViewModel(): Class<CategoryViewModel> {
        return CategoryViewModel::class.java
    }

    override fun initView() {
        isHideToolBar(true)
    }

    override fun initData() {
        mViewModel?.getCategory()
        mViewModel?.categoryList?.observe(this, Observer {

        })
    }

}