package com.cooleyepetizer.app.adapter.home

import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.databinding.ItemCullingTextHeaderBinding
import com.cooleyepetizer.app.databinding.ItemCullingVideoBinding
import com.cooleyepetizer.app.entity.eye_video.EyeItemBean
import com.cooleyepetizer.app.utils.ImageViewUtils

class CullingVideoAdapter : BaseMultiItemQuickAdapter<EyeItemBean,BaseViewHolder>() {

    init {
        addItemType(1, R.layout.item_culling_video)
        addItemType(2, R.layout.item_culling_text_header)
    }

    override fun convert(holder: BaseViewHolder, item: EyeItemBean) {
        when(holder.itemViewType){
            1 -> {
                val binding = DataBindingUtil.bind<ItemCullingVideoBinding>(holder.itemView)
                if (binding!=null){
                    ImageViewUtils.loadRoundImage(BaseApplication.instance,item.data.cover.detail,holder.getView(R.id.im_cull_video))
                    binding.cullingItem = item
                    binding.executePendingBindings()
                }
            }
            2 ->{
                val binding = DataBindingUtil.bind<ItemCullingTextHeaderBinding>(holder.itemView)
                if (binding!=null){
                    binding.cullingItem = item
                    binding.executePendingBindings()
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].geItemViewType()
    }

}