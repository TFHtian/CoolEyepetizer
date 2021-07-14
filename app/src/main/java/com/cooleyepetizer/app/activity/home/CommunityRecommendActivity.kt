package com.cooleyepetizer.app.activity.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.community.CommRecDetailAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmActivity
import com.cooleyepetizer.app.databinding.ActivityCommunityRecommendBinding
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean
import com.cooleyepetizer.app.utils.AutoPlayPageChangeListener
import com.cooleyepetizer.app.utils.IntentDataHolderUtil
import com.cooleyepetizer.app.viewmodel.community.CommRecActViewModel
import com.gyf.immersionbar.ImmersionBar
import kotlinx.android.synthetic.main.activity_community_recommend.*
import org.jetbrains.anko.toast

/**
 * @author fenghui
 * @date 2021/7/14.
 * @description 社区推荐页面
 */
class CommunityRecommendActivity : BaseMvvmActivity<ActivityCommunityRecommendBinding,CommRecActViewModel>(){

    private val adapter: CommRecDetailAdapter by lazy { CommRecDetailAdapter(this) }

    override fun onBindViewModel(): Class<CommRecActViewModel> {
        return CommRecActViewModel::class.java
    }

    override fun onBindLayout(): Int {
        return R.layout.activity_community_recommend
    }

    override fun setStatusBar() {
        ImmersionBar.with(this)
            .titleBar(viewBar)
            .statusBarDarkFont(true)
            .init()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkArguments()
    }

    override fun initView() {
        isHideToolBar(true)
    }

    override fun initData() {

        if (mViewModel?.dataList == null) {
            mViewModel?.itemPosition = getCurrentItemPosition()
            mViewModel?.dataList = IntentDataHolderUtil.getData<List<EyeListItemBean>>(EXTRA_RECOMMEND_ITEM_LIST_JSON)
        }
        if (mViewModel?.dataList == null) {
            toast("数据异常")
            finish()
        } else {
            mBinding?.run {
                viewPager.adapter = adapter
                viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
                viewPager.offscreenPageLimit = 1
                mViewModel?.let {
                    val onPageChangeCallback = AutoPlayPageChangeListener(viewPager, it.itemPosition, R.id.videoPlayer)
                    viewPager.registerOnPageChangeCallback(onPageChangeCallback)
                    viewPager.setCurrentItem(it.itemPosition, false)
                }
            }
        }
        adapter.setList(mViewModel?.dataList)
    }

    private fun checkArguments() = if (IntentDataHolderUtil.getData<List<EyeListItemBean>>(EXTRA_RECOMMEND_ITEM_LIST_JSON).isNullOrEmpty()
        || IntentDataHolderUtil.getData<EyeListItemBean>(EXTRA_RECOMMEND_ITEM_JSON) == null
    ) {
        toast("跳转异常")
        finish()
        false
    } else {
        true
    }

    suspend fun getData(): List<EyeListItemBean>? {
        return IntentDataHolderUtil.getData<List<EyeListItemBean>>(EXTRA_RECOMMEND_ITEM_LIST_JSON)
    }

    private fun getCurrentItemPosition(): Int {
        var position = -1
        val list = IntentDataHolderUtil.getData<List<EyeListItemBean>>(EXTRA_RECOMMEND_ITEM_LIST_JSON)
        val currentItem = IntentDataHolderUtil.getData<EyeListItemBean>(EXTRA_RECOMMEND_ITEM_JSON)
        list?.forEachIndexed { index, item ->
            if (currentItem == item) {
                mViewModel?.itemPosition = index
                return@forEachIndexed
            }
        }
        mViewModel?.let {
            position = it.itemPosition
        }
        return  position
    }

    companion object {
        private const val EXTRA_RECOMMEND_ITEM_LIST_JSON = "recommend_item_list"
        private const val EXTRA_RECOMMEND_ITEM_JSON = "recommend_item"

        fun start(context: Activity, dataList: List<EyeListItemBean>, currentItem: EyeListItemBean) {
            IntentDataHolderUtil.setData(EXTRA_RECOMMEND_ITEM_LIST_JSON, dataList)
            IntentDataHolderUtil.setData(EXTRA_RECOMMEND_ITEM_JSON, currentItem)
            val starter = Intent(context, CommunityRecommendActivity::class.java)
            context.startActivity(starter)
            context.overridePendingTransition(R.anim.anl_push_bottom_in, R.anim.anl_push_up_out)
        }
    }

}