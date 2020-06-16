package com.cooleyepetizer.app.entity.eye_video

data class EyeItemResponse(
    val adExist: Boolean,
    val count: Int,
    val itemList: ArrayList<EyeListItemBean>,
    val nextPageUrl: String,
    val total: Int
)