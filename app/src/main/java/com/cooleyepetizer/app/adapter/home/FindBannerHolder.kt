package com.cooleyepetizer.app.adapter.home

import android.view.View
import androidx.databinding.DataBindingUtil
import com.cooleyepetizer.app.databinding.FindBannerImageLayoutBinding
import com.cooleyepetizer.app.entity.eye_video.EyeItemBean
import com.zhpan.bannerview.BaseViewHolder

class FindBannerHolder(itemView: View) : BaseViewHolder<EyeItemBean>(itemView) {

    override fun bindData(data: EyeItemBean?, position: Int, pageSize: Int) {
        val binding = DataBindingUtil.bind<FindBannerImageLayoutBinding>(itemView)
        if (binding!=null){
            binding.item = data
            binding.executePendingBindings()
        }
    }
}