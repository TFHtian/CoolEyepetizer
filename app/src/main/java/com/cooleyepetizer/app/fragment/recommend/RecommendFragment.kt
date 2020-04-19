package com.cooleyepetizer.app.fragment.recommend

import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.home.TabLayoutAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseFragment
import com.cooleyepetizer.app.databinding.FragmentRecommendBinding
import com.cooleyepetizer.app.utils.TabLayoutManage
import com.gyf.immersionbar.ImmersionBar
import kotlinx.android.synthetic.main.fragment_recommend.*
import kotlinx.android.synthetic.main.top_tab_layout.*

class RecommendFragment : BaseFragment<FragmentRecommendBinding>(){

    override fun onBindLayout(): Int {
        return R.layout.fragment_recommend
    }

    override fun initView() {
        isHideToolBar(true)
        isHideToolBar(true)
        val tabTitles = arrayOf(resources.getString(R.string.follow),resources.getString(R.string.category))
        val fragmentList = arrayListOf(
            FollowFragment(),
            CategoryFragment()
        )
        view_pager_recommend.adapter = TabLayoutAdapter(fragmentList,tabTitles,childFragmentManager)
        view_pager_recommend.offscreenPageLimit = 1
        tab_top.setViewPager(view_pager_recommend)
        TabLayoutManage.topTabTextStyle(view_pager_recommend,tab_top)
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