package com.cooleyepetizer.app.entity.eye_video

import com.chad.library.adapter.base.entity.MultiItemEntity
import java.io.Serializable

data class EyeListItemBean (
    val adIndex: Int,
    val `data`: EyeItemDataBean,
    val id: Int,
    val tag: Any,
    val type: String,
    override var itemType: Int
): MultiItemEntity, Serializable {

    fun geItemViewType(): Int{
        return when (type) {
            "horizontalScrollCard" -> 1
            "specialSquareCardCollection" -> 2
            "columnCardList" -> 3
            "textCard" -> 4
            "banner" -> 5
            "videoSmallCard" -> 6
            "briefCard" -> 7
            "followCard" -> 8
            "informationCard" -> 9
            "ugcSelectedCardCollection" -> 10
            "communityColumnsCard" -> 11
            "autoPlayFollowCard" -> 12
            else -> 0
        }
    }
}