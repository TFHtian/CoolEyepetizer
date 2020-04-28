package com.cooleyepetizer.app.entity.eye_video

data class EyeHeaderBean(
    val actionUrl: String,
    val adTrack: Any,
    val description: String,
    val expert: Boolean,
    val follow: EyeFollowBean,
    val icon: String,
    val iconType: String,
    val id: Int,
    val ifPgc: Boolean,
    val ifShowNotificationIcon: Boolean,
    val subTitle: Any,
    val title: String,
    val uid: Int
)
