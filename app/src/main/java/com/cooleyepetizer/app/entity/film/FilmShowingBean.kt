package com.cooleyepetizer.app.entity.film

data class FilmShowingBean(
    val bImg: String,
    val date: String,
    val hasPromo: Boolean,
    val lid: Int,
    val ms: ArrayList<ShowingM>,
    val newActivitiesTime: Int,
    val promo: ShowingPromo,
    val totalComingMovie: Int,
    val voucherMsg: String
)
