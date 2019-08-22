package com.lpen.library.utils

/**
 * @author android_p
 * @date 2019/8/22
 */
object FastClickHelper {

    private var lastClickTime: Long = 0

    private const val INTERVAL = 500

    fun isNotFastClick(): Boolean = !isFastClick()

    fun isNotFastClick(ms: Int) = !isFastClick(ms)

    fun isFastClick(): Boolean =
        isFastClick(INTERVAL)

    fun isFastClick(ms: Int): Boolean {
        if (System.currentTimeMillis() - lastClickTime > ms) {
            lastClickTime = System.currentTimeMillis()
            return false
        }
        return true
    }

}