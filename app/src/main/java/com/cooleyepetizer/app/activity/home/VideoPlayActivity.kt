package com.cooleyepetizer.app.activity.home

import android.annotation.TargetApi
import android.os.Build
import android.transition.Transition
import android.util.Log
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.lifecycle.Observer
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.config.Constant
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmActivity
import com.cooleyepetizer.app.databinding.ActivityVideoPlayBinding
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean
import com.cooleyepetizer.app.glide.GlideApp
import com.cooleyepetizer.app.viewmodel.home.VideoPlayViewModel
import com.gyf.immersionbar.ImmersionBar
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import kotlinx.android.synthetic.main.activity_video_play.*

class VideoPlayActivity : BaseMvvmActivity<ActivityVideoPlayBinding,VideoPlayViewModel>(){

    companion object {
        const val IMG_TRANSITION = "IMG_TRANSITION"
        const val TRANSITION = "TRANSITION"
    }

    private lateinit var itemData: EyeListItemBean
    private var orientationUtils: OrientationUtils? = null

    private var isTransition: Boolean = false
    private var transition: Transition? = null

    override fun onBindViewModel(): Class<VideoPlayViewModel> {
        return VideoPlayViewModel::class.java
    }

    override fun onBindLayout(): Int {
       return R.layout.activity_video_play
    }

    override fun setStatusBar() {
        ImmersionBar.with(this)
            .titleBar(video_view)
            .statusBarDarkFont(true)
            .init()
    }

    override fun initView() {
        isHideToolBar(true)
    }

    override fun initData() {
        /*获取跳转传过来的数据*/
        itemData = intent.getSerializableExtra(Constant.BUNDLE_VIDEO_DATA) as EyeListItemBean
        isTransition = intent.getBooleanExtra(TRANSITION, false)

        /*初始化视频的配置*/
        initVideoView()

        /*初始过度动画*/
        initTransition()
    }

    /*视频的配置*/
    private fun initVideoView() {
        //设置旋转
        orientationUtils = OrientationUtils(this, video_view)
        //是否旋转
        video_view.isRotateViewAuto = false
        //是否可以滑动调整
        video_view.setIsTouchWiget(true)

        //增加封面
        val imageView = ImageView(this)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        GlideApp.with(this)
            .load(itemData.data.content.data.cover.detail)
            .centerCrop()
            .into(imageView)

        GlideApp.with(this)
            .load(itemData.data.content.data.cover.detail)
            .centerCrop()
            .format(DecodeFormat.PREFER_ARGB_8888)
            .transition(DrawableTransitionOptions().crossFade())
            .into(im_video_bg)

        video_view.thumbImageView = imageView

        //设置返回按键功能
        video_view.backButton.setOnClickListener { onBackPressed() }
        //设置全屏按键功能
        video_view.fullscreenButton.setOnClickListener {
            //直接横屏
            orientationUtils?.resolveByClick()
            //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏status_bar
            video_view.startWindowFullscreen(this, true, true)
        }
        //锁屏事件
        video_view.setLockClickListener { _, lock ->
            //配合下方的onConfigurationChanged
            orientationUtils?.isEnable = !lock
        }
    }

    /*过度动画*/
    private fun initTransition() {
        if (isTransition && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            postponeEnterTransition()
            ViewCompat.setTransitionName(video_view, IMG_TRANSITION)
            addTransitionListener()
            startPostponedEnterTransition()
        } else {
            loadVideo()
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun addTransitionListener() {
        transition = window.sharedElementEnterTransition
        transition?.addListener(object : Transition.TransitionListener {
            override fun onTransitionResume(p0: Transition?) {
            }

            override fun onTransitionPause(p0: Transition?) {
            }

            override fun onTransitionCancel(p0: Transition?) {
            }

            override fun onTransitionStart(p0: Transition?) {
            }

            override fun onTransitionEnd(p0: Transition?) {
                loadVideo()
                transition?.removeListener(this)
            }

        })
    }

    /*播放视频*/
    private fun loadVideo(){
        mViewModel?.getVideoDetail(itemData.data.content.data.id.toLong())
        mViewModel?.videoDetailList?.observe(this, Observer {
            Log.e("wwwwwwwwwwww","----${it.size}")
        })
    }

}