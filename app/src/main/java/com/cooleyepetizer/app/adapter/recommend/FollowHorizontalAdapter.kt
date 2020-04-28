package com.cooleyepetizer.app.adapter.recommend

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ItemFollowHorizontalBinding
import com.cooleyepetizer.app.entity.eye_video.EyeItemBean

class FollowHorizontalAdapter : BaseQuickAdapter<EyeItemBean,BaseDataBindingHolder<ItemFollowHorizontalBinding>>(
    R.layout.item_follow_horizontal){
    override fun convert(
        holder: BaseDataBindingHolder<ItemFollowHorizontalBinding>,
        item: EyeItemBean
    ) {
        val binding: ItemFollowHorizontalBinding? = holder.dataBinding
        if (binding != null) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

}