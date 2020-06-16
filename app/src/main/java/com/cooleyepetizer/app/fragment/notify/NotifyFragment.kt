package com.cooleyepetizer.app.fragment.notify

import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.home.TabLayoutAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseFragment
import com.cooleyepetizer.app.databinding.FragmentNotifyBinding
import com.cooleyepetizer.app.utils.TabLayoutManage
import com.gyf.immersionbar.ImmersionBar
import kotlinx.android.synthetic.main.fragment_notify.*
import kotlinx.android.synthetic.main.top_tab_layout.*

class NotifyFragment : BaseFragment<FragmentNotifyBinding>(){

    override fun onBindLayout(): Int {
        return R.layout.fragment_notify
    }

    override fun initView() {
        isHideToolBar(true)
        val tabTitles = arrayOf(resources.getString(R.string.push),resources.getString(R.string.interact))
        val fragmentList = arrayListOf(
            NotifyPushFragment(),
            NotifyInteractFragment()
        )
        view_page_notify.adapter = TabLayoutAdapter(fragmentList,tabTitles,childFragmentManager)
        view_page_notify.offscreenPageLimit = 1
        tab_top.setViewPager(view_page_notify)
        TabLayoutManage.topTabTextStyle(view_page_notify,tab_top)
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