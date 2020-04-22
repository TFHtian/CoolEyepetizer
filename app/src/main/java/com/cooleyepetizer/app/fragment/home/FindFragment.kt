package com.cooleyepetizer.app.fragment.home

import androidx.lifecycle.Observer
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.home.FindBannerAdapter
import com.cooleyepetizer.app.adapter.home.FindBannerHolder
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmFragment
import com.cooleyepetizer.app.databinding.FragmentFindBinding
import com.cooleyepetizer.app.entity.eye_video.EyeItemBean
import com.cooleyepetizer.app.viewmodel.home.HomeViewModel
import com.zhpan.bannerview.BannerViewPager
import com.zhpan.bannerview.constants.PageStyle
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle

class FindFragment : BaseMvvmFragment<FragmentFindBinding, HomeViewModel>() {

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
            .setInterval(3000)
            .setIndicatorSlideMode(IndicatorSlideMode.SMOOTH)
            .setPageMargin(resources.getDimensionPixelOffset(R.dimen.dp_15))
            .setRevealWidth(resources.getDimensionPixelOffset(R.dimen.dp_15))
            .setAdapter(homeAdapter)
            .create()
    }

    override fun initData() {
        mViewModel?.getHomeFirstData()
        mViewModel?.bannerList?.observe(this, Observer {
            mViewPager.refreshData(it)
        })
    }

    override fun onBindLayout(): Int {
        return R.layout.fragment_find
    }

    override fun onBindViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }
}