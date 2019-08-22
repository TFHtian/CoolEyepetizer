package com.lpen.library.base

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt


/**
 * @author android_p
 * @date 2019/8/22
 */
open class BaseViewModel : AbsViewModel() {

    val title = ObservableField<String>()
    val showBack = ObservableBoolean(true)
    val showMenuTxt = ObservableBoolean(false)
    val menuText = ObservableField<String>()
    val showMenuImg = ObservableBoolean(false)
    val menuIcon = ObservableInt()

}