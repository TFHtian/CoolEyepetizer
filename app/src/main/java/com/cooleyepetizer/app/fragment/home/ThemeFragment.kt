package com.cooleyepetizer.app.fragment.home

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.home.HomeListAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmRefreshFragment
import com.cooleyepetizer.app.databinding.FragmentThemeBinding
import com.cooleyepetizer.app.viewmodel.home.ThemeViewModel
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.fragment_theme.*

class ThemeFragment : BaseMvvmRefreshFragment<FragmentThemeBinding,ThemeViewModel>(){

    private var apiUrl: String? = null
    private val themeAdapter by lazy { activity?.let { HomeListAdapter(it) } }

    companion object {
        fun getInstance(apiUrl: String): ThemeFragment {
            val fragment = ThemeFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.apiUrl = apiUrl
            return fragment
        }
    }

    override fun getRefreshLayout(): SmartRefreshLayout {
        return refresh_layout
    }

    override fun onBindViewModel(): Class<ThemeViewModel> {
        return ThemeViewModel::class.java
    }

    override fun onBindLayout(): Int {
        return R.layout.fragment_theme
    }

    override fun initView() {
        isHideToolBar(true)
        theme_list.adapter = themeAdapter
        theme_list.layoutManager = LinearLayoutManager(mActivity)
    }

    override fun initData() {
        mViewModel?.getThemeListData(apiUrl!!)
        mViewModel?.themeList?.observe(this, Observer {
            themeAdapter?.setList(it)
        })
    }

    override fun loadDataByRefresh() {

    }

    override fun loadDataByLoadMore() {

    }

}