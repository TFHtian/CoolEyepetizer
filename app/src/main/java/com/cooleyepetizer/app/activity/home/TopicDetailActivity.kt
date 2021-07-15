package com.cooleyepetizer.app.activity.home

import android.graphics.Color
import androidx.lifecycle.Observer
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.config.Constant
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmActivity
import com.cooleyepetizer.app.databinding.ActivityTopicDetailBinding
import com.cooleyepetizer.app.glide.GlideUtils
import com.cooleyepetizer.app.viewmodel.home.TopicDetailViewModel
import com.gyf.immersionbar.ImmersionBar
import kotlinx.android.synthetic.main.activity_topic_detail.*
import kotlinx.android.synthetic.main.activity_topic_detail.collapsing_toolbar_layout
import kotlinx.android.synthetic.main.activity_topic_detail.toolbar

/**
 * @author fenghui
 * @date 2021/7/15.
 * @description 话题详情页
 */
class TopicDetailActivity : BaseMvvmActivity<ActivityTopicDetailBinding,TopicDetailViewModel>(){

    var id: Int? = null

    override fun onBindViewModel(): Class<TopicDetailViewModel> {
        return TopicDetailViewModel::class.java
    }

    override fun onBindLayout(): Int {
        return R.layout.activity_topic_detail
    }

    override fun setStatusBar() {
        ImmersionBar.with(this)
            .titleBar(toolbar)
            .statusBarDarkFont(false)
            .init()
    }

    override fun initView() {
        isHideToolBar(true)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
        collapsing_toolbar_layout.setExpandedTitleColor(Color.WHITE)
        collapsing_toolbar_layout.setCollapsedTitleTextColor(Color.BLACK)
    }

    override fun initData() {
        id = intent.getIntExtra(Constant.ID,0)
        id?.let {
            mViewModel?.getTopicDetail(it.toLong())
        }
        mViewModel?.detailBean?.observe(this, Observer {
            mBinding?.detailBean = it
            GlideUtils.loadImage(this,imHead,it.headPicture,0)
        })
    }

}