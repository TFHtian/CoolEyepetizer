package com.cooleyepetizer.app.entity.eye_video

import java.io.Serializable

data class EyeConsumptionBean (
    val collectionCount: Int,
    val realCollectionCount: Int,
    val replyCount: Int,
    val shareCount: Int
) : Serializable