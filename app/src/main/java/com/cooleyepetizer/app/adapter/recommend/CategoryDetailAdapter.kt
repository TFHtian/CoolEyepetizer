package com.cooleyepetizer.app.adapter.recommend

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ItemCategoryDetailBinding
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean
import com.cooleyepetizer.app.listener.HomeEventHandler

class CategoryDetailAdapter : BaseQuickAdapter<EyeListItemBean, BaseDataBindingHolder<ItemCategoryDetailBinding>>(
    R.layout.item_category_detail){

    val listener by lazy { HomeEventHandler() }

    override fun convert(
        holder: BaseDataBindingHolder<ItemCategoryDetailBinding>,
        item: EyeListItemBean
    ) {
        val binding: ItemCategoryDetailBinding? = holder.dataBinding
        if (binding != null) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

}