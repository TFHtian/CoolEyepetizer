package com.cooleyepetizer.app.entity.eye_video

data class EyePlayInfoBean (
    val height: Int,
    val name: String,
    val type: String,
    val url: String,
    val urlList: List<EyeUrlBean>,
    val width: Int
)