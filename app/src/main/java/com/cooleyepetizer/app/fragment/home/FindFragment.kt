package com.cooleyepetizer.app.fragment.home

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.home.FindBannerAdapter
import com.cooleyepetizer.app.adapter.home.FindBannerHolder
import com.cooleyepetizer.app.adapter.home.TabLayoutAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmFragment
import com.cooleyepetizer.app.databinding.FragmentFindBinding
import com.cooleyepetizer.app.entity.eye_video.EyeItemBean
import com.cooleyepetizer.app.entity.eye_video.EyeRankTabInfo
import com.cooleyepetizer.app.viewmodel.home.HomeViewModel
import com.flyco.tablayout.listener.OnTabSelectListener
import com.zhpan.bannerview.BannerViewPager
import com.zhpan.bannerview.constants.PageStyle
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle
import kotlinx.android.synthetic.main.fragment_find.*

class FindFragment : BaseMvvmFragment<FragmentFindBinding, HomeViewModel>() {

    private val mTabTitleList = ArrayList<String>()

    private val mFragmentList = ArrayList<Fragment>()

    private lateinit var mViewPager: BannerViewPager<EyeItemBean, FindBannerHolder>

    override fun initView() {
        isHideToolBar(true)
        isHideToolBar(true)
        mViewPager = mActivity.findViewById(R.id.banner_find)
        val homeAdapter = FindBannerAdapter()
        mViewPager
            .setScrollDuration(600)
            .setIndicatorSlideMode(IndicatorSlideMode.SCALE)
            .setIndicatorStyle(IndicatorStyle.CIRCLE)
            .setIndicatorSliderColor(resources.getColor(R.color.transparent),resources.getColor(R.color.transparent))
            .setPageStyle(PageStyle.MULTI_PAGE)
            .setInterval(5000)
            .setIndicatorSlideMode(IndicatorSlideMode.SMOOTH)
            .setPageMargin(resources.getDimensionPixelOffset(R.dimen.dp_5))
            .setRevealWidth(resources.getDimensionPixelOffset(R.dimen.dp_10))
            .setAdapter(homeAdapter)
            .create()
    }

    override fun initData() {
        mViewModel?.getHomeFirstData()
        mViewModel?.getRankTabInfo()
        mViewModel?.bannerList?.observe(this, Observer {
            mViewPager.refreshData(it)
        })
        mViewModel?.tabInfo?.observe(this, Observer {
            initRankFragment(it)
        })
    }

    override fun onBindLayout(): Int {
        return R.layout.fragment_find
    }

    override fun onBindViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    private fun initRankFragment(tabInfo: EyeRankTabInfo){
        tabInfo.tabInfo.tabList.mapTo(mTabTitleList) { it.name }
        tabInfo.tabInfo.tabList.mapTo(mFragmentList) { RankFragment.getInstance(it.apiUrl) }
        val tabTitles = arrayOf(mTabTitleList[0],mTabTitleList[1],mTabTitleList[2])
        view_page_rank.adapter = TabLayoutAdapter(mFragmentList,tabTitles,childFragmentManager)
        view_page_rank.offscreenPageLimit = 2
        tab_rank.setTabData(tabTitles)
        tab_rank.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                view_page_rank.currentItem = position
            }

            override fun onTabReselect(position: Int) {}
        })

        view_page_rank.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
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
        view_page_rank.currentItem = 0
    }
}