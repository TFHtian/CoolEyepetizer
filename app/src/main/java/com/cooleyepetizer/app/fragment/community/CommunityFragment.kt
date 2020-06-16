package com.cooleyepetizer.app.fragment.community

import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.home.TabLayoutAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseFragment
import com.cooleyepetizer.app.databinding.FragmentCommunityBinding
import com.cooleyepetizer.app.utils.TabLayoutManage
import com.gyf.immersionbar.ImmersionBar
import kotlinx.android.synthetic.main.fragment_community.*
import kotlinx.android.synthetic.main.top_tab_layout.*

class CommunityFragment : BaseFragment<FragmentCommunityBinding>(){

    override fun onBindLayout(): Int {
        return R.layout.fragment_community
    }

    override fun setStatusBar() {
        ImmersionBar.with(this)
            .titleBar(top_tab_toolbar)
            .keyboardEnable(false)
            .statusBarDarkFont(false)
            .init()
    }

    override fun initView() {
        isHideToolBar(true)
        val tabTitles = arrayOf(resources.getString(R.string.recommend),resources.getString(R.string.follow))
        val fragmentList = arrayListOf(
            CommunityRecommendFragment(),
            CommunityFollowFragment()
        )
        view_pager_community.adapter = TabLayoutAdapter(fragmentList,tabTitles,childFragmentManager)
        view_pager_community.offscreenPageLimit = 1
        tab_top.setViewPager(view_pager_community)
        TabLayoutManage.topTabTextStyle(view_pager_community,tab_top)
    }

    override fun initData() {

    }

}