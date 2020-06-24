package com.cooleyepetizer.app.entity.eye_video

import java.io.Serializable

data class EyeFollowBean (
    val followed: Boolean,
    val itemId: Int,
    val itemType: String
): Serializable