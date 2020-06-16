package com.cooleyepetizer.app.entity.notify

data class NotifyInteractBean(
    val adExist: Boolean,
    val count: Int,
    val itemList: ArrayList<NotifyInteractItemBean>,
    val nextPageUrl: String,
    val total: Int
)
