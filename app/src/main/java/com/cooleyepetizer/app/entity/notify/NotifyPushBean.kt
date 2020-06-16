package com.cooleyepetizer.app.entity.notify

data class NotifyPushBean(
    val messageList: ArrayList<NotifyMessageBean>,
    val nextPageUrl: String,
    val updateTime: Long
)