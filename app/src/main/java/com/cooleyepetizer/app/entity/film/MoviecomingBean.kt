package com.cooleyepetizer.app.entity.film

data class MoviecomingBean (
    val actor1: String,
    val actor2: String,
    val director: String,
    val id: Int,
    val image: String,
    val isFilter: Boolean,
    val isTicket: Boolean,
    val isVideo: Boolean,
    val locationName: String,
    val rDay: Int,
    val rMonth: Int,
    val rYear: Int,
    val releaseDate: String,
    val title: String,
    val type: String,
    val videoCount: Int,
    val videos: List<ComingVideo>,
    val wantedCount: Int
)