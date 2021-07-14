package com.cooleyepetizer.app.adapter.community

import android.content.Context
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ItemPhotosBinding
import com.cooleyepetizer.app.glide.GlideUtils

class PhotosAdapter(private var mContext: Context) : BaseQuickAdapter<String, BaseDataBindingHolder<ItemPhotosBinding>>(
    R.layout.item_photos){

    override fun convert(holder: BaseDataBindingHolder<ItemPhotosBinding>, item: String) {
        val binding: ItemPhotosBinding? = holder.dataBinding
        binding?.run {
            GlideUtils.loadImage(mContext,photoView,item,0)
            executePendingBindings()
        }
    }

}