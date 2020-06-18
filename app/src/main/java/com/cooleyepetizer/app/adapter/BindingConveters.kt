package com.cooleyepetizer.app.adapter

import java.text.SimpleDateFormat
import java.util.*

object ConverterDateTimeUtil {

    @JvmStatic fun formatSeconds(seconds: Long): String {
        return when {
            seconds <= 0 -> {
                "00:00"
            }
            seconds < 60 -> {
                String.format(Locale.getDefault(), "00:%02d", seconds % 60)
            }
            seconds < 3600 -> {
                String.format(Locale.getDefault(), "%02d:%02d", seconds / 60, seconds % 60)
            }
            else -> {
                String.format(Locale.getDefault(), "%02d:%02d:%02d", seconds / 3600, seconds % 3600 / 60, seconds % 60)
            }
        }
    }

    @JvmStatic fun formatDate(time: Long): String{
        val date = Date(time)
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return format.format(date)
    }

}