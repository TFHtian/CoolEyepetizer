package com.cooleyepetizer.app.entity.notify

data class NotifyInteractDataBean (
    val actionUrl: String,
    val dataType: String,
    val haveReward: Boolean,
    val id: Int,
    val ifNewest: Boolean,
    val imageUrl: String,
    val joinCount: Int,
    val newestEndTime: Long,
    val showHotSign: Boolean,
    val title: String,
    val viewCount: Int
)