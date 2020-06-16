package com.cooleyepetizer.app.adapter.home

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ItemSquareCategoryBinding
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean

class SquareCategoryAdapter : BaseQuickAdapter<EyeListItemBean, BaseDataBindingHolder<ItemSquareCategoryBinding>>(R.layout.item_square_category){
    override fun convert(
        holder: BaseDataBindingHolder<ItemSquareCategoryBinding>,
        item: EyeListItemBean
    ) {
        val binding: ItemSquareCategoryBinding? = holder.dataBinding
        if (binding != null) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

}