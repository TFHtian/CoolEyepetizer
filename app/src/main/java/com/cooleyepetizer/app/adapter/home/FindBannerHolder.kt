package com.cooleyepetizer.app.adapter.home

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.entity.eye_video.EyeItemBean
import com.cooleyepetizer.app.utils.ImageViewUtils
import com.zhpan.bannerview.BaseViewHolder

class FindBannerHolder(itemView: View) : BaseViewHolder<EyeItemBean>(itemView) {

    override fun bindData(data: EyeItemBean?, position: Int, pageSize: Int) {
        val imageView = itemView.findViewById<ImageView>(R.id.im_find_banner)
        val tvTitle = itemView.findViewById<TextView>(R.id.tv_banner_title)
        tvTitle.text = data?.data?.title
        ImageViewUtils.loadRoundImage(BaseApplication.instance,data?.data?.cover?.detail,imageView)
    }
}