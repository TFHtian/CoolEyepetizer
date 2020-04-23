package com.cooleyepetizer.app.glide

import android.content.Context
import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.cooleyepetizer.app.R

class GlideUtils private constructor(){

    companion object{

        /**
         * 加载图片
         *
         * @param context  context
         * @param iv       imageView
         * @param url      图片地址
         * @param emptyImg 默认展位图
         */
        fun loadImage(
            context: Context?,
            iv: ImageView,
            url: String?,
            emptyImg: Int
        ) {
            if (!TextUtils.isEmpty(url)) {
                GlideApp.with(context!!)
                    .load(url)
                    .error(emptyImg)
                    .placeholder(R.color.image_default_color)
                    .into(iv)
            } else {
                loadImage(context, iv, emptyImg, emptyImg)
            }
        }

        /**
         * 加载圆角图片
         *
         * @param context  context
         * @param iv       imageView
         * @param url      图片地址
         * @param emptyImg 默认展位图
         */
        fun loadRoundImage(
            context: Context?,
            iv: ImageView,
            url: String?,
            emptyImg: Int
        ) {
            if (!TextUtils.isEmpty(url)) {
                GlideApp.with(context!!)
                    .load(url)
                    .error(emptyImg)
                    .placeholder(R.color.image_default_color)
                    .transform(GlideRoundTransform(15))
                    .into(iv)
            } else {
                loadRoundImage(context, iv, emptyImg, emptyImg)
            }
        }

        /**
         * 加载圆形图片
         *
         * @param context  context
         * @param iv       imageView
         * @param url      图片地址
         * @param emptyImg 默认展位图
         */
        fun loadCircleImage(
            context: Context?,
            iv: ImageView,
            url: String?,
            emptyImg: Int
        ) {
            if (!TextUtils.isEmpty(url)) {
                GlideApp.with(context!!)
                    .load(url)
                    .error(emptyImg)
                    .placeholder(R.color.image_default_color)
                    .transition(DrawableTransitionOptions().crossFade())
                    .transform(CircleCrop()).into(iv)
            } else {
                loadCircleImage(context, iv, emptyImg, emptyImg)
            }
        }


        /**
         * 加载drawable中的图片资源
         *
         * @param context  context
         * @param iv       imageView
         * @param resId    图片地址
         * @param emptyImg 默认展位图
         */
        private fun loadImage(
            context: Context?,
            iv: ImageView?,
            resId: Int,
            emptyImg: Int
        ) {
            GlideApp.with(context!!).load(resId).placeholder(emptyImg).into(iv!!)
        }

        /**
         * 加载drawable中的图片资源 圆角
         *
         * @param context  context
         * @param iv       imageView
         * @param resId    图片地址
         * @param emptyImg 默认展位图
         */
        private fun loadRoundImage(
            context: Context?,
            iv: ImageView?,
            resId: Int,
            emptyImg: Int
        ) {
            GlideApp.with(context!!).load(emptyImg).placeholder(emptyImg)
                .transform(RoundedCorners(20)).into(iv!!)
        }

        /**
         * 加载drawable中的图片资源 圆形
         *
         * @param context  context
         * @param iv       imageView
         * @param resId    图片地址
         * @param emptyImg 默认展位图
         */
        private fun loadCircleImage(
            context: Context?,
            iv: ImageView?,
            resId: Int,
            emptyImg: Int
        ) {
            GlideApp.with(context!!).load(emptyImg).placeholder(emptyImg).transform(CircleCrop())
                .into(iv!!)
        }
    }
}