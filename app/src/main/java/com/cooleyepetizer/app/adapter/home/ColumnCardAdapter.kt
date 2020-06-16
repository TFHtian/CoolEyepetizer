package com.cooleyepetizer.app.adapter.home

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ItemColumnCardBinding
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean

class ColumnCardAdapter  : BaseQuickAdapter<EyeListItemBean, BaseDataBindingHolder<ItemColumnCardBinding>>(
    R.layout.item_column_card){
    override fun convert(
        holder: BaseDataBindingHolder<ItemColumnCardBinding>,
        item: EyeListItemBean
    ) {
        val binding: ItemColumnCardBinding? = holder.dataBinding
        if (binding != null) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

}