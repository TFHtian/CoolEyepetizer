package com.lpen.library.bindAdapter

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter


/**
 * @author android_p
 * @date 2019/8/22
 */
object ImageViewBindAdapter {

    @BindingAdapter(value = ["iconRes"], requireAll = false)
    @JvmStatic
    fun onBindIcon(view: ImageView, @DrawableRes icon: Int) {
        if (icon == 0) {
            view.setImageResource(android.R.color.transparent)
        } else {
            view.setImageResource(icon)
        }
    }

}