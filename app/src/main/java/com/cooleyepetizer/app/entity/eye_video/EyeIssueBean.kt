package com.cooleyepetizer.app.entity.eye_video

data class EyeIssueBean (
    val count: Int,
    val date: Long,
    val itemList: ArrayList<EyeItemBean>,
    val publishTime: Long,
    val releaseTime: Long,
    val type: String
)