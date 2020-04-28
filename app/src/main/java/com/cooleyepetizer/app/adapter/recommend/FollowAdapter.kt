package com.cooleyepetizer.app.adapter.recommend

import android.app.Activity
import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ItemFollowBinding
import com.cooleyepetizer.app.entity.eye_video.EyeItemBean

class FollowAdapter(val contaxt: Context) : BaseQuickAdapter<EyeItemBean,BaseDataBindingHolder<ItemFollowBinding>>(R.layout.item_follow){
    override fun convert(holder: BaseDataBindingHolder<ItemFollowBinding>, item: EyeItemBean) {
        val binding: ItemFollowBinding? = holder.dataBinding
        if (binding != null) {
            /*horizon列表*/
            val horizontalAdapter = FollowHorizontalAdapter()
            binding.followHorizonList.adapter = horizontalAdapter
            binding.followHorizonList.layoutManager = LinearLayoutManager(contaxt as Activity,LinearLayoutManager.HORIZONTAL,false)
            horizontalAdapter.setList(item?.data?.itemList)
            /*item信息*/
            binding.item = item
            binding.executePendingBindings()
        }

    }
}