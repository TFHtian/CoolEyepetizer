package com.cooleyepetizer.app.fragment.home

import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.home.TabLayoutAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseFragment
import com.cooleyepetizer.app.databinding.FragmentHomeBinding
import com.cooleyepetizer.app.utils.TabLayoutManage
import kotlinx.android.synthetic.main.fragment_home.*

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
        view_page_home.adapter = TabLayoutAdapter(fragmentList,tabTitles,childFragmentManager)
        view_page_home.offscreenPageLimit = 1
        tab_top.setViewPager(view_page_home)
        TabLayoutManage.topTabTextStyle(view_page_home,tab_top)
    }

    override fun initData() {}

}