package com.lpen.library.base

import android.content.Context
import android.view.Gravity
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import com.lpen.library.R


/**
 * @author android_p
 * @date 2019/8/22
 */
abstract class BaseDialog(context: Context, gravity: Int = Gravity.BOTTOM)
    : AlertDialog(context, R.style.DialogTheme) {

    init {
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        window?.setGravity(gravity)
        when (gravity) {
            Gravity.BOTTOM -> {
                window?.setWindowAnimations(R.style.BottomDialogAnimation)
            }
            Gravity.CENTER -> {
                window?.setWindowAnimations(R.style.CenterDialogAnimation)
            }
        }

        if (getWidthIsFull()) {
            setWidthMatchContent()
        } else {
            setWidthWrapContent()
        }
    }

    abstract fun getWidthIsFull(): Boolean

    private fun setWidthWrapContent() {
        window?.decorView?.setPadding(0, 0, 0, 0)
        val lp = window?.attributes
        lp?.width = WindowManager.LayoutParams.WRAP_CONTENT
        lp?.height = WindowManager.LayoutParams.WRAP_CONTENT
        window?.attributes = lp
    }

    private fun setWidthMatchContent() {
        window?.decorView?.setPadding(0, 0, 0, 0)
        val lp = window?.attributes
        lp?.width = WindowManager.LayoutParams.MATCH_PARENT
        lp?.height = WindowManager.LayoutParams.WRAP_CONTENT
        window?.attributes = lp
    }

}