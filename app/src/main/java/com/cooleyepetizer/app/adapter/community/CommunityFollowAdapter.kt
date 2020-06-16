package com.cooleyepetizer.app.adapter.community

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ItemCommunityFollowBinding
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean

class CommunityFollowAdapter : BaseQuickAdapter<EyeListItemBean, BaseDataBindingHolder<ItemCommunityFollowBinding>>(
    R.layout.item_community_follow) {

    override fun convert(holder: BaseDataBindingHolder<ItemCommunityFollowBinding>, item: EyeListItemBean) {
        val binding: ItemCommunityFollowBinding? = holder.dataBinding
        if (binding != null) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
}