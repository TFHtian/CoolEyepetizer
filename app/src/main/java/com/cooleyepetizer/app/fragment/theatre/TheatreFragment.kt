package com.cooleyepetizer.app.fragment.theatre

import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.home.TabLayoutAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseFragment
import com.cooleyepetizer.app.databinding.FragmentTheatreBinding
import com.cooleyepetizer.app.utils.TabLayoutManage
import com.gyf.immersionbar.ImmersionBar
import kotlinx.android.synthetic.main.fragment_theatre.*
import kotlinx.android.synthetic.main.top_tab_layout.*

class TheatreFragment : BaseFragment<FragmentTheatreBinding>(){

    override fun onBindLayout(): Int {
        return R.layout.fragment_theatre
    }

    override fun initView() {
        isHideToolBar(true)
        val tabTitles = arrayOf(resources.getString(R.string.film_coming),resources.getString(R.string.film_showing))
        val fragmentList = arrayListOf(
            FilmComingFragment(),
            FilmShowingFragment()
        )
        view_page_theatre.adapter = TabLayoutAdapter(fragmentList,tabTitles,childFragmentManager)
        view_page_theatre.offscreenPageLimit = 1
        tab_top.setViewPager(view_page_theatre)
        TabLayoutManage.topTabTextStyle(view_page_theatre,tab_top)
    }

    override fun initData() {

    }

    override fun setStatusBar() {
        ImmersionBar.with(this)
            .titleBar(top_tab_toolbar)
            .keyboardEnable(false)
            .statusBarDarkFont(false)
            .init()
    }

}