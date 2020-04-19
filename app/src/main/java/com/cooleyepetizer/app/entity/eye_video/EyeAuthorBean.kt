package com.cooleyepetizer.app.entity.eye_video

data class EyeAuthorBean (
    val adTrack: Any,
    val approvedNotReadyVideoCount: Int,
    val description: String,
    val expert: Boolean,
    val follow: Follow,
    val icon: String,
    val id: Int,
    val ifPgc: Boolean,
    val latestReleaseTime: Long,
    val link: String,
    val name: String,
    val recSort: Int,
    val shield: EyeShieldBean,
    val videoNum: Int
)