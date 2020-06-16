package com.cooleyepetizer.app.adapter
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.glide.GlideApp
import com.cooleyepetizer.app.glide.GlideRoundTransform

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view:ImageView,imageUrl:String){
    if(!imageUrl.isNullOrEmpty()){
        GlideApp.with(view.context!!)
            .load(imageUrl)
            .placeholder(R.color.image_default_color)
            .into(view)
    }
}

@BindingAdapter("imageTransFromUrl")
fun bindImageTransFromUrl(view:ImageView,imageUrl:String?){
    if(!imageUrl.isNullOrEmpty()){
        GlideApp.with(view.context!!)
            .load(imageUrl)
            .placeholder(R.color.image_default_color)
            .transform(GlideRoundTransform(5))
            .into(view)
    }
}

@BindingAdapter("imageCircleFromUrl")
fun bindImageCircleFromUrl(view:ImageView,imageUrl:String?){
    if(!imageUrl.isNullOrEmpty()){
        GlideApp.with(view.context!!)
            .load(imageUrl)
            .placeholder(R.color.image_default_color)
            .transform(CircleCrop()).into(view)
    }

@BindingAdapter("goneUnless")
fun goneUnless(view: View,visible: Boolean){
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

}

