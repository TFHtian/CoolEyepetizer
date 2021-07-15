package com.cooleyepetizer.app.entity.eye_video

data class TopicDetailBean(
    val content: String,
    val headPicture: String,
    val id: Int,
    val joinCount: Int,
    val linkDesc: String,
    val linkUrl: String,
    val shareLink: String,
    val showHotSign: Boolean,
    val tagList: List<Any>,
    val title: String,
    val user: Any,
    val viewCount: Int
)