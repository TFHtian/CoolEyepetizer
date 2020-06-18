package com.cooleyepetizer.app.fragment.recommend

import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmFragment
import com.cooleyepetizer.app.databinding.FragmentCategoryBinding
import com.cooleyepetizer.app.viewmodel.home.CategoryViewModel

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

    }
}