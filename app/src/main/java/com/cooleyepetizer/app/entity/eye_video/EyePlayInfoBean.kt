package com.cooleyepetizer.app.entity.eye_video

import java.io.Serializable

data class EyePlayInfoBean (
    val height: Int,
    val name: String,
    val type: String,
    val url: String,
    val urlList: List<EyeUrlBean>,
    val width: Int
): Serializable