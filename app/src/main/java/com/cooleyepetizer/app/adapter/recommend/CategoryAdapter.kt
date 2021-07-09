package com.cooleyepetizer.app.adapter.recommend

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ItemCategoryBinding
import com.cooleyepetizer.app.entity.eye_video.CategoryBean
import com.cooleyepetizer.app.entity.eye_video.EyeCategoryBean
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean
import com.cooleyepetizer.app.listener.HomeEventHandler

class CategoryAdapter : BaseQuickAdapter<CategoryBean,BaseDataBindingHolder<ItemCategoryBinding>>(
    R.layout.item_category){

    val listener by lazy { HomeEventHandler() }

    override fun convert(
        holder: BaseDataBindingHolder<ItemCategoryBinding>,
        item: CategoryBean
    ) {
        val binding: ItemCategoryBinding? = holder.dataBinding
        if (binding != null) {
            binding.item = item
            binding.listener = listener
            binding.executePendingBindings()
        }
    }

}