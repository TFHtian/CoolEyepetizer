package com.lpen.library.utils

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.lang.Exception

object ImgLoadUtil {

    fun loadImg(context: Context?, url: String?, imgView: ImageView?) {
        if (context == null || imgView == null || (context is Activity && context.isDestroyed)) return
        try {
            Glide.with(context)
                .load(url)
                .into(imgView)
        } catch (e: Exception) {

        }
    }

    fun loadImg(context: Context?, url: String?, @DrawableRes placeHolder: Int, imgView: ImageView?) {
        if (context == null || imgView == null || (context is Activity && context.isDestroyed)) return
        try {
            Glide.with(context)
                .load(url)
                .apply(RequestOptions.placeholderOf(placeHolder))
                .into(imgView)
        } catch (e: Exception) {

        }
    }

    fun loadCircleImg(context: Context?, url: String?, imgView: ImageView?) {
        if (context == null || imgView == null || (context is Activity && context.isDestroyed)) return
        try {
            Glide.with(context)
                .load(url)
                .apply(RequestOptions.circleCropTransform())
                .into(imgView)
        } catch (e: Exception) {

        }
    }

    fun loadCircleImg(context: Context?, url: String?, @DrawableRes placeHolder: Int, imgView: ImageView?) {
        if (context == null || imgView == null || (context is Activity && context.isDestroyed)) return
        try {
            Glide.with(context)
                .load(url)
                .apply(
                    RequestOptions
                        .placeholderOf(placeHolder)
                        .circleCrop()
                ).into(imgView)
        } catch (e: Exception) {

        }
    }

    fun loadImgAsBitmap(context: Context?, url: String?, imgView: ImageView?) {
        if (context == null || imgView == null || (context is Activity && context.isDestroyed)) return
        try {
            Glide.with(context)
                .asBitmap()
                .load(url)
                .into(imgView)
        } catch (e: Exception) {

        }
    }

    fun loadImgAsBitmap(context: Context?, url: String?, @DrawableRes placeHolder: Int, imgView: ImageView?) {
        if (context == null || imgView == null || (context is Activity && context.isDestroyed)) return
        try {
            Glide.with(context)
                .asBitmap()
                .load(url)
                .apply(RequestOptions.placeholderOf(placeHolder))
                .into(imgView)
        } catch (e: Exception) {

        }
    }

    fun loadImgAsBitmap(context: Context?, url: String?, @DrawableRes placeHolder: Int, @DrawableRes errorHolder: Int, imgView: ImageView?) {
        if (context == null || imgView == null || (context is Activity && context.isDestroyed)) return
        try {
            Glide.with(context)
                .asBitmap()
                .load(url)
                .apply(RequestOptions.placeholderOf(placeHolder).error(errorHolder))
                .into(imgView)
        } catch (e: Exception) {

        }
    }

    fun loadCircleImgAsBitmap(context: Context?, url: String?, imgView: ImageView?) {
        if (context == null || imgView == null || (context is Activity && context.isDestroyed)) return
        try {
            Glide.with(context)
                .asBitmap()
                .load(url)
                .apply(RequestOptions.circleCropTransform())
                .into(imgView)
        } catch (e: Exception) {

        }
    }

    fun loadCircleImgAsBitmap(context: Context?, url: String?, @DrawableRes placeHolder: Int, imgView: ImageView?) {
        if (context == null || imgView == null || (context is Activity && context.isDestroyed)) return
        try {
            Glide.with(context)
                .asBitmap()
                .load(url)
                .apply(
                    RequestOptions
                        .placeholderOf(placeHolder)
                        .circleCrop()
                ).into(imgView)
        } catch (e: Exception) {

        }
    }

    fun loadBitmap(context: Context?, bitmap: Bitmap?, imgView: ImageView?) {
        if (context == null || imgView == null || (context is Activity && context.isDestroyed)) return
        try {
            Glide.with(context)
                .load(bitmap)
                .into(imgView)
        } catch (e: Exception) {

        }
    }

    fun loadBitmap(context: Context?, bitmap: Bitmap?, @DrawableRes placeHolder: Int, imgView: ImageView?) {
        if (context == null || imgView == null || (context is Activity && context.isDestroyed)) return
        try {
            Glide.with(context)
                .load(bitmap)
                .apply(RequestOptions.placeholderOf(placeHolder))
                .into(imgView)
        } catch (e: Exception) {

        }
    }

    fun loadBitmap(context: Context?, bitmap: Bitmap?, @DrawableRes placeHolder: Int, @DrawableRes errorHolder: Int, imgView: ImageView?) {
        if (context == null || imgView == null || (context is Activity && context.isDestroyed)) return
        try {
            Glide.with(context)
                .load(bitmap)
                .apply(RequestOptions.placeholderOf(placeHolder).error(errorHolder))
                .into(imgView)
        } catch (e: Exception) {

        }
    }

    fun gaussianBlur(context: Context?, bitmap: Bitmap?, imgView: ImageView?) {
        if (context == null || imgView == null || (context is Activity && context.isDestroyed)) return
        try {
            Glide.with(context)
                .asBitmap()
                .load(bitmap)
                .apply(RequestOptions.bitmapTransform((GlideBlurformation(context))))
                .into(imgView)
        } catch (e: Exception) {

        }
    }

    fun gaussianBlur(context: Context?, url: String?, imgView: ImageView?) {
        if (context == null || imgView == null || (context is Activity && context.isDestroyed)) return
        try {
            Glide.with(context)
                .asBitmap()
                .load(url)
                .apply(RequestOptions.bitmapTransform((GlideBlurformation(context))))
                .into(imgView)
        } catch (e: Exception) {

        }
    }

}