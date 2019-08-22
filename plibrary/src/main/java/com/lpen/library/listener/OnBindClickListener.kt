package com.lpen.library.listener

import android.view.View
import com.lpen.library.utils.FastClickHelper


/**
 * xml 中绑定事件使用:
 *  如果点击事件需要防快速点击，使用：
 *      android:onClick="@{(v) -> listener.onClick(v)}"
 *  如果点击事件不需要防快速点击，使用：
 *      android:onClick="@{(v) -> listener.onViewClick(v)}"
 *
 *  代码中实现 onViewClick() 方法
 *
 * @author android_p
 * @date 2019/8/22
 */
interface OnBindClickListener : View.OnClickListener {

    override fun onClick(v: View?) {
        if (FastClickHelper.isNotFastClick()) {
            onViewClick(v)
        }
    }


    fun onViewClick(v: View?)

}