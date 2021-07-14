package com.cooleyepetizer.app.adapter.community

import android.content.Context
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ItemCommunityFollowBinding
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean
import com.cooleyepetizer.app.listener.HomeEventHandler
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

class CommunityFollowAdapter(private var mContext: Context) : BaseQuickAdapter<EyeListItemBean, BaseDataBindingHolder<ItemCommunityFollowBinding>>(
    R.layout.item_community_follow) {

    val listener by lazy { HomeEventHandler() }

    override fun convert(holder: BaseDataBindingHolder<ItemCommunityFollowBinding>, item: EyeListItemBean) {
        val binding: ItemCommunityFollowBinding? = holder.dataBinding
        if (binding != null) {
            binding.item = item
            binding.listener = listener
            binding.activity = mContext as RxAppCompatActivity
            binding.executePendingBindings()
        }
    }
}