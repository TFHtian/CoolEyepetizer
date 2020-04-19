package com.cooleyepetizer.app.fragment.home

import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.home.TabLayoutAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseFragment
import com.cooleyepetizer.app.databinding.FragmentHomeBinding
import com.cooleyepetizer.app.utils.TabLayoutManage
import com.gyf.immersionbar.ImmersionBar
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.top_tab_layout.*

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun onBindLayout(): Int {
        return R.layout.fragment_home
    }

    override fun initView() {
        isHideToolBar(true)
        val tabTitles = arrayOf(resources.getString(R.string.culling),resources.getString(R.string.find))
        val fragmentList = arrayListOf(
            CullingFragment(),
            FindFragment()
        )
        view_pager_home.adapter = TabLayoutAdapter(fragmentList,tabTitles,childFragmentManager)
        view_pager_home.offscreenPageLimit = 1
        tab_top.setViewPager(view_pager_home)
        TabLayoutManage.topTabTextStyle(view_pager_home,tab_top)
    }

    override fun initData() {}

    override fun setStatusBar() {
        ImmersionBar.with(this)
            .titleBar(top_tab_toolbar)
            .keyboardEnable(false)
            .statusBarDarkFont(false)
            .init()
    }

}