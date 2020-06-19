package com.cooleyepetizer.app.adapter.home

import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.config.BaseApplication.Companion.instance
import com.cooleyepetizer.app.databinding.*
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean
import com.cooleyepetizer.app.listener.HomeEventHandler
import com.zhpan.bannerview.BannerViewPager
import com.zhpan.bannerview.constants.PageStyle
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle

class HomeListAdapter : BaseMultiItemQuickAdapter<EyeListItemBean, BaseViewHolder>() {

    val listener by lazy { HomeEventHandler() }

    init {
        addItemType(1, R.layout.item_home_horizontal_scroll_card)
        addItemType(2, R.layout.item_home_special_square_card)
        addItemType(3, R.layout.item_home_column_card)
        addItemType(4, R.layout.item_home_text_card)
        addItemType(5, R.layout.item_home_banner_card)
        addItemType(6, R.layout.item_home_video_small_card)
        addItemType(7, R.layout.item_home_brief_card)
        addItemType(8, R.layout.item_home_follow_card)
        addItemType(9, R.layout.item_home_information_card)
        addItemType(10, R.layout.item_home_ugc_card)
        addItemType(11, R.layout.item_home_other_card)
        addItemType(12, R.layout.item_home_other_card)
        addItemType(0, R.layout.item_home_other_card)
    }

    override fun convert(holder: BaseViewHolder, item: EyeListItemBean) {
        when (holder.itemViewType) {
            1 -> {
                /*轮播广告*/
                lateinit var mViewPager: BannerViewPager<EyeListItemBean, FindBannerHolder>
                val binding =
                    DataBindingUtil.bind<ItemHomeHorizontalScrollCardBinding>(holder.itemView)
                if (binding != null) {
                    mViewPager = holder.itemView.findViewById(R.id.banner_find)
                    val homeAdapter = FindBannerAdapter()
                    mViewPager
                        .setScrollDuration(600)
                        .setIndicatorSlideMode(IndicatorSlideMode.SCALE)
                        .setIndicatorStyle(IndicatorStyle.CIRCLE)
                        .setIndicatorSliderColor(
                            instance.resources.getColor(R.color.transparent),
                            instance.resources.getColor(R.color.transparent)
                        )
                        .setPageStyle(PageStyle.MULTI_PAGE)
                        .setInterval(5000)
                        .setIndicatorSlideMode(IndicatorSlideMode.SMOOTH)
                        .setPageMargin(instance.resources.getDimensionPixelOffset(R.dimen.dp_5))
                        .setRevealWidth(instance.resources.getDimensionPixelOffset(R.dimen.dp_10))
                        .setAdapter(homeAdapter)
                        .create()
                    mViewPager.refreshData(item.data.itemList)
                    binding.executePendingBindings()
                }
            }
            2 -> {
                /*热门分类*/
                val squareCategoryAdapter = SquareCategoryAdapter()
                val binding = DataBindingUtil.bind<ItemHomeSpecialSquareCardBinding>(holder.itemView)
                if (binding != null) {
                    binding.categoryList.adapter = squareCategoryAdapter
                    binding.categoryList.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
                    val view: View =
                        LayoutInflater.from(instance).inflate(R.layout.item_category_none_layout, binding.categoryList, false)
                    binding.categoryList.addHeaderView(view)
                    binding.categoryList.addFooterView(view)
                    squareCategoryAdapter.setList(item.data.itemList)
                    binding.item = item
                    binding.listener = listener
                    binding.executePendingBindings()
                }
            }
            3 -> {
                /*专题策划*/
                val columnCardAdapter = ColumnCardAdapter()
                val binding =
                    DataBindingUtil.bind<ItemHomeColumnCardBinding>(holder.itemView)
                if (binding != null) {
                    binding.columnList.adapter = columnCardAdapter
                    binding.columnList.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                    columnCardAdapter.setList(item.data.itemList)
                    binding.item = item
                    binding.executePendingBindings()
                }
            }
            4 -> {
                /*标题栏*/
                val binding =
                    DataBindingUtil.bind<ItemHomeTextCardBinding>(holder.itemView)
                if (binding != null){
                    /*判断dataType类型*/
                    when(item.data.dataType){
                        "TextCardWithRightAndLeftTitle" ->{
                            binding.isShowTitle = true
                            binding.isShowFollow = false
                            binding.isShowMore = false
                        }
                        "TextCard" ->{
                            binding.isShowTitle = true
                            binding.isShowFollow = true
                            binding.isShowMore = false
                        }
                        "TextCardWithTagId" ->{
                            binding.isShowTitle = false
                            binding.isShowFollow = false
                            binding.isShowMore = true
                        }
                    }
                    binding.item = item
                    binding.listener = listener
                    binding.executePendingBindings()
                }
            }
            5 -> {
                /*展示图banner*/
                val binding =
                    DataBindingUtil.bind<ItemHomeBannerCardBinding>(holder.itemView)
                if (binding != null){
                    binding.item = item
                    binding.executePendingBindings()
                }
            }
            6 -> {
                /*video_small*/
                val binding =
                    DataBindingUtil.bind<ItemHomeVideoSmallCardBinding>(holder.itemView)
                if (binding != null){
                    binding.item = item
                    binding.executePendingBindings()
                }
            }
            7 -> {
                /*brief_card*/
                val binding =
                    DataBindingUtil.bind<ItemHomeBriefCardBinding>(holder.itemView)
                if (binding != null){
                    binding.showFollow = item.data.getBriefShowFollow()
                    binding.item = item
                    binding.executePendingBindings()
                }
            }
            8 -> {
                /*follow_card*/
                val binding =
                    DataBindingUtil.bind<ItemHomeFollowCardBinding>(holder.itemView)
                if (binding != null){
                    binding.item = item
                    binding.executePendingBindings()
                }
            }
            9 -> {
                /*information_card*/
                val binding =
                    DataBindingUtil.bind<ItemHomeInformationCardBinding>(holder.itemView)
                if (binding != null){
                    binding.item = item
                    binding.content = item.data.getInformationContent()
                    binding.executePendingBindings()
                }
            }
            10 -> {
                /*information_card*/
                val binding =
                    DataBindingUtil.bind<ItemHomeUgcCardBinding>(holder.itemView)
                if (binding != null){
                    binding.item = item
                    binding.executePendingBindings()
                }
            }
            0,11,12 ->{

            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].geItemViewType()
    }

}