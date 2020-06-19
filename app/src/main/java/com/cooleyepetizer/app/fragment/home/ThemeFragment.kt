package com.cooleyepetizer.app.fragment.home

import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmRefreshFragment
import com.cooleyepetizer.app.databinding.FragmentThemeBinding
import com.cooleyepetizer.app.viewmodel.home.ThemeViewModel
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.fragment_theme.*

class ThemeFragment : BaseMvvmRefreshFragment<FragmentThemeBinding,ThemeViewModel>(){

    override fun getRefreshLayout(): SmartRefreshLayout {
        return refresh_layout
    }

    override fun onBindViewModel(): Class<ThemeViewModel> {
        return ThemeViewModel::class.java
    }

    override fun onBindLayout(): Int {
        return R.layout.fragment_theme
    }

    override fun loadDataByRefresh() {

    }

    override fun loadDataByLoadMore() {

    }

}