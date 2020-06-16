package com.cooleyepetizer.app.entity.eye_video

import com.chad.library.adapter.base.entity.MultiItemEntity

data class EyeItemBean (
    val adIndex: Int,
    val `data`: EyeDataBean,
    val id: Int,
    val tag: Any,
    val type: String,
    override var itemType: Int
) : MultiItemEntity {

    fun geItemViewType(): Int{
        return when (type) {
            "horizontalScrollCard" -> 1
            "specialSquareCardCollection" -> 2
            "columnCardList" -> 3
            "textCard" -> 4
            "banner" -> 5
            "videoSmallCard" -> 6
            "briefCard" -> 7
            else -> 0
        }
    }
}