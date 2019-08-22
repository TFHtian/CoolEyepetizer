package com.lpen.library.base

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient


/**
 * @author android_p
 * @date 2019/8/14
 */
fun Activity.initStatusBar() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        try {
            val decorViewClazz = Class.forName("com.android.internal.policy.DecorView")
            val field = decorViewClazz.getDeclaredField("mSemiTransparentStatusBarColor")
            field.isAccessible = true
            field.setInt(window.decorView, Color.TRANSPARENT)  //改为透明
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

fun Activity.setStatusBarIconColor(isBlack: Boolean) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (isBlack) {    //设置状态栏黑色字体
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {    // 状态栏白色字体
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
        }
    }
}


@SuppressLint("SetJavaScriptEnabled")
fun WebView.initWebSettings(mChromeClient: WebChromeClient? = null) {
    settings?.javaScriptEnabled = true
    settings?.useWideViewPort = true
    settings?.loadWithOverviewMode = true
    settings?.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
    settings?.domStorageEnabled = true
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        settings?.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
    }
    setOnLongClickListener { true }
    isFocusable = false
    requestFocus()
    webChromeClient = mChromeClient
    webViewClient = object : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url)
            return false
        }
    }
}
