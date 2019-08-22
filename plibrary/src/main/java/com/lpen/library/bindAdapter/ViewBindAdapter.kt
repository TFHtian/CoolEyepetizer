package com.lpen.library.bindAdapter

import android.view.View
import androidx.databinding.BindingAdapter

/**
 * @author android_p
 * @date 2019/8/22
 */
object ViewBindAdapter {

    @BindingAdapter(value = ["isShow", "isVisible"], requireAll = false)
    @JvmStatic
    fun onBindViewVisible(view: View, isShow: Boolean? = true, isVisible: Boolean? = true) {
        if (isShow != null) {
            if (isShow) {
                view.visibility = View.VISIBLE
            } else {
                view.visibility = View.GONE
            }
        } else if (isVisible != null) {
            if (isVisible) {
                view.visibility = View.VISIBLE
            } else {
                view.visibility = View.INVISIBLE
            }
        }
    }

}