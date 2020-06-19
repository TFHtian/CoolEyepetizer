package com.cooleyepetizer.app.listener

import android.content.Intent
import android.util.Log
import com.cooleyepetizer.app.activity.home.CategoryActivity
import com.cooleyepetizer.app.activity.home.RankActivity
import com.cooleyepetizer.app.activity.home.ThemeActivity
import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean

class HomeEventHandler {

    fun jumpToCategoryAll(){
        val intent = Intent(BaseApplication.instance,CategoryActivity::class.java)
        BaseApplication.instance.startActivity(intent)
    }

    fun jumpToRank(){
        val intent = Intent(BaseApplication.instance, ThemeActivity::class.java)
        BaseApplication.instance.startActivity(intent)
    }

}