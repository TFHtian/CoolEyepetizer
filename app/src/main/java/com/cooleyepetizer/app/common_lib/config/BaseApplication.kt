package com.cooleyepetizer.app.common_lib.config

import android.app.Application
import kotlin.properties.Delegates

class BaseApplication  : Application(){

    companion object {
        var instance: BaseApplication by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
    }
}