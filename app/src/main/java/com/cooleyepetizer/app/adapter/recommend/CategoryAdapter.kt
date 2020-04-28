package com.cooleyepetizer.app.adapter.recommend

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ItemCategoryBinding
import com.cooleyepetizer.app.entity.eye_video.EyeCategoryBean

class CategoryAdapter : BaseQuickAdapter<EyeCategoryBean,BaseDataBindingHolder<ItemCategoryBinding>>(
    R.layout.item_category){
    override fun convert(
        holder: BaseDataBindingHolder<ItemCategoryBinding>,
        item: EyeCategoryBean
    ) {
        val binding: ItemCategoryBinding? = holder.dataBinding
        if (binding != null) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

}