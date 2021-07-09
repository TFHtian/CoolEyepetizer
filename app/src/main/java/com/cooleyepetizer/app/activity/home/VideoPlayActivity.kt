package com.cooleyepetizer.app.activity.home

import android.annotation.TargetApi
import android.content.res.Configuration
import android.os.Build
import android.transition.Transition
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
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
import com.shuyu.gsyvideoplayer.GSYVideoManager
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

    private var isPlay: Boolean = false
    private var isPause = false

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

        setBackground(itemData.data.content.data.cover.blurred)

        /*初始化视频的配置*/
        initVideoView()

        /*初始过度动画*/
        initTransition()

        /*初始内容列表*/
        initContentListView()
    }

    private fun initContentListView(){

        //relatedAdapter = NewDetailRelatedAdapter(this, viewModel.relatedDataList, viewModel.videoInfoData)
        //replyAdapter = NewDetailReplyAdapter(this, viewModel.repliesDataList)
        //mergeAdapter = ConcatAdapter(relatedAdapter, replyAdapter)
        mBinding?.rvContent?.layoutManager = LinearLayoutManager(this)
        //binding.recyclerView.adapter = mergeAdapter
        mBinding?.rvContent?.setHasFixedSize(true)
        mBinding?.rvContent?.itemAnimator = null
        mBinding?.refreshLayout?.run {
            setDragRate(0.7f)
            setHeaderTriggerRate(0.6f)
            setFooterTriggerRate(0.6f)
            setEnableLoadMoreWhenContentNotFull(true)
            setEnableFooterFollowWhenNoMoreData(true)
            setEnableFooterTranslationContent(true)
            setEnableScrollContentWhenLoaded(true)
            setEnableNestedScroll(true)
            setOnRefreshListener { finish() }
            setOnLoadMoreListener {
                //viewModel.onLoadMore()
            }
        }
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
        //设置URL
        video_view.setUp(itemData.data.content.data.playUrl, false, "")
        //开始自动播放
        video_view.startPlayLogic()
        //获取详情数据
        mViewModel?.getVideoDetail(itemData.data.content.data.id.toLong())
        mViewModel?.videoDetailList?.observe(this, Observer {

        })
    }

    private fun setBackground(url: String) {
        GlideApp.with(this)
            .load(url)
            .centerCrop()
            .format(DecodeFormat.PREFER_ARGB_8888)
            .transition(DrawableTransitionOptions().crossFade())
            .into(im_video_bg)
    }

    /* 监听返回键*/
    override fun onBackPressed() {
        if (orientationUtils != null) {
            orientationUtils!!.backToProtVideo()
        }
        if (GSYVideoManager.backFromWindowFull(this)) {
            return
        }
        super.onBackPressed()
    }

    override fun onPause() {
        video_view.currentPlayer.onVideoPause()
        super.onPause()
        isPause = true
    }

    override fun onResume() {
        video_view.currentPlayer.onVideoResume(false)
        super.onResume()
        isPause = false
    }

    override fun onDestroy() {
        super.onDestroy()
        video_view.gsyVideoManager
            .setListener(
                video_view.gsyVideoManager
                    .lastListener()
            )
        video_view.gsyVideoManager.setLastListener(null)
        GSYVideoManager.releaseAllVideos()
        if (orientationUtils != null) {
            orientationUtils!!.releaseListener()
            orientationUtils = null
        }
        video_view.release()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (isPlay && !isPause) {
            video_view.onConfigurationChanged(this, newConfig, orientationUtils)
        }
    }

}