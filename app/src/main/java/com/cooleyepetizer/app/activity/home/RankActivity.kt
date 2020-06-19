package com.cooleyepetizer.app.activity.home

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.home.TabLayoutAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmActivity
import com.cooleyepetizer.app.databinding.ActivityRankBinding
import com.cooleyepetizer.app.entity.eye_video.EyeRankTabInfo
import com.cooleyepetizer.app.fragment.home.RankFragment
import com.cooleyepetizer.app.viewmodel.home.RankViewModel
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.activity_rank.*

class RankActivity : BaseMvvmActivity<ActivityRankBinding, RankViewModel>(){

    private val mTabTitleList = ArrayList<String>()

    private val mFragmentList = ArrayList<Fragment>()

    override fun onBindViewModel(): Class<RankViewModel> {
        return RankViewModel::class.java
    }

    override fun onBindLayout(): Int {
        return R.layout.activity_rank
    }

    override fun initView() {
        setCenterTitle(this.resources.getString(R.string.hot_rank))
    }

    override fun initData() {
        mViewModel?.getRankTabInfo()
        mViewModel?.tabInfo?.observe(this, Observer {
            initRankFragment(it)
        })
    }

    private fun initRankFragment(tabInfo: EyeRankTabInfo){
        tabInfo.tabInfo.tabList.mapTo(mTabTitleList) { it.name }
        tabInfo.tabInfo.tabList.mapTo(mFragmentList) { RankFragment.getInstance(it.apiUrl) }
        val tabTitles = arrayOf(mTabTitleList[0],mTabTitleList[1],mTabTitleList[2])
        view_pager_rank.adapter = TabLayoutAdapter(mFragmentList,tabTitles,supportFragmentManager)
        view_pager_rank.offscreenPageLimit = 2
        tab_rank.setTabData(tabTitles)
        tab_rank.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                view_pager_rank.currentItem = position
            }

            override fun onTabReselect(position: Int) {}
        })

        view_pager_rank.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                tab_rank.currentTab = position
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
        view_pager_rank.currentItem = 0
    }

}