package com.cooleyepetizer.app.adapter.community

import android.util.Log
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ItemCommunityColumnsCardBinding
import com.cooleyepetizer.app.databinding.ItemCommunityTopHeadCardBinding
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean

class CommunityRecommendAdapter : BaseMultiItemQuickAdapter<EyeListItemBean, BaseViewHolder>() {

    init {
        addItemType(1, R.layout.item_community_top_head_card)
        addItemType(11, R.layout.item_community_columns_card)
    }

    override fun convert(holder: BaseViewHolder, item: EyeListItemBean) {
        when (holder.itemViewType) {
            1 -> {
                val layoutParams =
                    StaggeredGridLayoutManager.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                layoutParams.isFullSpan = true
                holder.itemView.layoutParams = layoutParams
                val binding =
                    DataBindingUtil.bind<ItemCommunityTopHeadCardBinding>(holder.itemView)
                if(binding != null){
                    /*判断dataType的类型*/
                    when(item.data.dataType){
                        "ItemCollection" ->{
                            binding.isShowBanner = false
                            binding.isShowCollection = true
                        }
                        "HorizontalScrollCard" ->{
                            binding.isShowBanner = true
                            binding.isShowCollection = false
                        }
                    }
                    binding.item = item
                    binding.executePendingBindings()
                }
            }
            11 ->{
                val binding =
                DataBindingUtil.bind<ItemCommunityColumnsCardBinding>(holder.itemView)
                if (binding != null){
                    binding.item = item
                    binding.executePendingBindings()
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].geItemViewType()
    }

}