package com.lpen.library.utils;

import android.content.Context;
import android.graphics.Bitmap;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;

import java.security.MessageDigest;

/**
 * Created by yukuoyuan on 2017/9/29.
 */
public class GlideBlurformation extends CenterCrop {
    private Context context;

    public GlideBlurformation(Context context) {
        this.context = context;
    }

    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        Bitmap bitmap = super.transform(pool, toTransform, outWidth, outHeight);
        return BlurBitmapUtil.instance().blurBitmap(context, bitmap, 25, (int) (outWidth * 0.2), (int) (outHeight * 0.2));
    }

    @Override
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}