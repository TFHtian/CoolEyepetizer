package com.lpen.library.base

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.databinding.DataBindingUtil
import com.lpen.library.R
import com.lpen.library.databinding.DialogLoadingBinding


/**
 * @author android_p
 * @date 2019/8/22
 */
class LoadingDialog(context: Context, text: String? = ""): BaseDialog(context, Gravity.CENTER) {

    override fun getWidthIsFull() = false

    private var mBinding: DialogLoadingBinding? = null

    private var mRotateAnimation: Animation? = null
    private var animationCancel: Boolean = false

    init {
        val contentView: View = View.inflate(context, R.layout.dialog_loading, null)
        mBinding = DataBindingUtil.bind(contentView)
        setLoadingTips(text)
        initAnimation()

        setView(mBinding!!.root)
        setCanceledOnTouchOutside(false)
    }

    private fun initAnimation() {
        mRotateAnimation = RotateAnimation(0F, 360F, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F)
        mRotateAnimation?.duration = 1500
        mRotateAnimation?.isFillEnabled = true
        mRotateAnimation?.fillAfter = true
        mRotateAnimation?.repeatCount = -1
        mRotateAnimation?.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                if (!animationCancel) {
                    mBinding?.imgLoading?.startAnimation(mRotateAnimation)
                }
            }

            override fun onAnimationStart(animation: Animation?) {
            }

        })
    }

    fun setLoadingTips(tips: String?) {
        if (tips?.isNotEmpty() == true) {
            mBinding?.txtLoading?.text = tips
        }
    }

    override fun show() {
        super.show()
        animationCancel = false
        mBinding?.imgLoading?.startAnimation(mRotateAnimation)
    }

    override fun cancel() {
        super.cancel()
        animationCancel = true
    }

}