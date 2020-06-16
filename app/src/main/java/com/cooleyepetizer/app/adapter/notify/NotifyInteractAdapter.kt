package com.cooleyepetizer.app.adapter.notify

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ItemNotifyInteractBinding
import com.cooleyepetizer.app.entity.notify.NotifyInteractItemBean

class NotifyInteractAdapter : BaseQuickAdapter<NotifyInteractItemBean, BaseDataBindingHolder<ItemNotifyInteractBinding>>(
    R.layout.item_notify_interact) {

    override fun convert(holder: BaseDataBindingHolder<ItemNotifyInteractBinding>, item: NotifyInteractItemBean) {
        val binding: ItemNotifyInteractBinding? = holder.dataBinding
        if (binding != null) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
}