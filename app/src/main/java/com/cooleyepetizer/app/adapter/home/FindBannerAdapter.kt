package com.cooleyepetizer.app.adapter.home

import android.view.View
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.entity.eye_video.EyeItemBean
import com.zhpan.bannerview.BaseBannerAdapter

class FindBannerAdapter : BaseBannerAdapter<EyeItemBean,FindBannerHolder>(){

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.find_banner_image_layout
    }

    override fun createViewHolder(itemView: View, viewType: Int): FindBannerHolder {
        return FindBannerHolder(itemView)
    }

    override fun onBind(
        holder: FindBannerHolder?,
        data: EyeItemBean?,
        position: Int,
        pageSize: Int
    ) {
        holder?.bindData(data, position, pageSize)
    }
}