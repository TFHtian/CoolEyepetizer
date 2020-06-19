package com.cooleyepetizer.app.activity.home

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.home.TabLayoutAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmActivity
import com.cooleyepetizer.app.databinding.ActivityThemeBinding
import com.cooleyepetizer.app.entity.eye_video.EyeRankTabInfo
import com.cooleyepetizer.app.fragment.home.RankFragment
import com.cooleyepetizer.app.viewmodel.home.ThemeViewModel
import kotlinx.android.synthetic.main.activity_theme.*

class ThemeActivity : BaseMvvmActivity<ActivityThemeBinding,ThemeViewModel>(){

    private val mTabTitleList = ArrayList<String>()

    private val mFragmentList = ArrayList<Fragment>()

    override fun onBindViewModel(): Class<ThemeViewModel> {
       return ThemeViewModel::class.java
    }

    override fun onBindLayout(): Int {
        return R.layout.activity_theme
    }

    override fun initView() {
        setCenterTitle(this.resources.getString(R.string.theme_square))
    }

    override fun initData() {
        mViewModel?.getThemeTabInfo()
        mViewModel?.tabInfo?.observe(this, Observer {
            initThemeFragment(it)
        })
    }

    private fun initThemeFragment(tabInfo: EyeRankTabInfo){
        tabInfo.tabInfo.tabList.mapTo(mTabTitleList) { it.name }
        tabInfo.tabInfo.tabList.mapTo(mFragmentList) { RankFragment.getInstance(it.apiUrl) }
        view_pager_theme.adapter = TabLayoutAdapter(mFragmentList,mTabTitleList.toTypedArray(),supportFragmentManager)
        tab_theme.setViewPager(view_pager_theme)
    }

}