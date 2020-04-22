package com.cooleyepetizer.app.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.cooleyepetizer.app.R
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class ImageViewUtils {

    companion object{

        fun loadImage(
            context: Context?,
            imageUrl: String?,
            imageView: ImageView?,
            errorRes: Int
        ) {
            val options: RequestOptions = RequestOptions()
                .centerCrop()
                .error(errorRes)
                .placeholder(R.color.image_default_color)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
            Glide.with(context!!)
                .load(imageUrl)
                .apply(options)
                .into(imageView!!)
        }

        fun loadGoodDetailImage(
            context: Context?,
            imageUrl: String?,
            width: Int,
            height: Int,
            imageView: ImageView?,
            errorRes: Int
        ) {
            val options: RequestOptions = RequestOptions()
                .override(width, height)
                .error(errorRes)
                .placeholder(R.color.image_default_color)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
            Glide.with(context!!)
                .load(imageUrl)
                .apply(options)
                .into(imageView!!)
        }

        fun loadRoundImage(context: Context,
                           imageUrl: String?,
                           imageView: ImageView){
            Glide.with(context)
                .load(imageUrl)
                .apply(bitmapTransform(RoundedCornersTransformation(20, 0, RoundedCornersTransformation.CornerType.ALL)))
                .into(imageView)
        }
    }


}