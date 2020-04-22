package com.cooleyepetizer.app.adapter.home

import android.view.View
import android.widget.ImageView
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.entity.eye_video.EyeCoverBean
import com.cooleyepetizer.app.utils.ImageViewUtils
import com.zhpan.bannerview.BaseViewHolder

class FindBannerHolder(itemView: View) : BaseViewHolder<EyeCoverBean>(itemView) {

    override fun bindData(data: EyeCoverBean?, position: Int, pageSize: Int) {
        val imageView = itemView.findViewById<ImageView>(R.id.im_find_banner)
        ImageViewUtils.loadRoundImage(BaseApplication.instance,data?.detail,imageView)
    }
}