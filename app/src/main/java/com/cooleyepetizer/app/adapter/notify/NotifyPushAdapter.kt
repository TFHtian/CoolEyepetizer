package com.cooleyepetizer.app.adapter.notify

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ItemNotifyPushBinding
import com.cooleyepetizer.app.entity.notify.NotifyMessageBean

class NotifyPushAdapter : BaseQuickAdapter<NotifyMessageBean, BaseDataBindingHolder<ItemNotifyPushBinding>>(
    R.layout.item_notify_push) {

    override fun convert(holder: BaseDataBindingHolder<ItemNotifyPushBinding>, item: NotifyMessageBean) {
        val binding: ItemNotifyPushBinding? = holder.dataBinding
        if (binding != null) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
}