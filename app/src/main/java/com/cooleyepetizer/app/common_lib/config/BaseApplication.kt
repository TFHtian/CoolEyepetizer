package com.cooleyepetizer.app.common_lib.config

import androidx.multidex.MultiDexApplication
import kotlin.properties.Delegates

class BaseApplication  : MultiDexApplication(){

    companion object {
        var instance: BaseApplication by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
    }
}