package com.cooleyepetizer.app.entity.eye_video

import com.chad.library.adapter.base.entity.MultiItemEntity

data class EyeItemBean (
    val adIndex: Int,
    val `data`: EyeDataBean,
    val id: Int,
    val tag: Any,
    val type: String, override var itemType: Int
) : MultiItemEntity {

    fun geItemViewType(): Int{
        return when (type) {
            "video" -> 1
            "textHeader" -> 2
            "banner2" -> 3
            else -> 0
        }
    }
}