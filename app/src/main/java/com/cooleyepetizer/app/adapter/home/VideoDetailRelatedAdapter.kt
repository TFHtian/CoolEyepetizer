package com.cooleyepetizer.app.adapter.home

import android.content.Context
import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ItemVideoDetailCustomHeaderTypeBinding
import com.cooleyepetizer.app.databinding.ItemVideoDetailSmallCardBinding
import com.cooleyepetizer.app.databinding.ItemVideoTextCardBinding
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean

class VideoDetailRelatedAdapter(private var mContext: Context) : BaseMultiItemQuickAdapter<EyeListItemBean, BaseViewHolder>(){

    init {
        addItemType(13, R.layout.item_video_detail_custom_header_type)
        addItemType(4, R.layout.item_video_text_card)
        addItemType(6, R.layout.item_video_detail_small_card)
        addItemType(0, R.layout.item_home_other_card)
    }

    override fun convert(holder: BaseViewHolder, item: EyeListItemBean) {
        when (holder.itemViewType) {
            13 ->{
                val binding =
                    DataBindingUtil.bind<ItemVideoDetailCustomHeaderTypeBinding>(holder.itemView)
                if (binding != null){
                    binding.item = item
                    binding.executePendingBindings()
                }
            }
            4 ->{
                /*textCard*/
                val binding =
                    DataBindingUtil.bind<ItemVideoTextCardBinding>(holder.itemView)
                if (binding != null){
                    binding.item = item
                    binding.executePendingBindings()
                }
            }
            6 -> {
                /*video_small*/
                val binding =
                    DataBindingUtil.bind<ItemVideoDetailSmallCardBinding>(holder.itemView)
                if (binding != null){
                    binding.item = item
                    binding.tvContent.setTextColor(mContext.resources.getColor(R.color.colorWhite))
                    binding.executePendingBindings()
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].geItemViewType()
    }

}