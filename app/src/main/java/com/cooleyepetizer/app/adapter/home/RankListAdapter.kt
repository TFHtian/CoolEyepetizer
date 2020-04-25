package com.cooleyepetizer.app.adapter.home

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ItemRankBinding
import com.cooleyepetizer.app.entity.eye_video.EyeItemBean

class RankListAdapter : BaseQuickAdapter<EyeItemBean, BaseDataBindingHolder<ItemRankBinding>>(R.layout.item_rank) {

    override fun convert(holder: BaseDataBindingHolder<ItemRankBinding>, item: EyeItemBean) {
        val binding: ItemRankBinding? = holder.dataBinding
        if (binding != null) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
}