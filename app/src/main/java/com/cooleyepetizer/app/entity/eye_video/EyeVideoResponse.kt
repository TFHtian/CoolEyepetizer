package com.cooleyepetizer.app.entity.eye_video

data class EyeVideoResponse (
    val dialog: Any,
    val issueList: ArrayList<EyeIssueBean>,
    val newestIssueType: String,
    val nextPageUrl: String,
    val nextPublishTime: Long
)