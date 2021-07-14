package com.cooleyepetizer.app.activity.home

import android.graphics.Color
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.recommend.CategoryDetailAdapter
import com.cooleyepetizer.app.common_lib.config.Constant
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmRefreshActivity
import com.cooleyepetizer.app.databinding.ActivityCategoryDetailBinding
import com.cooleyepetizer.app.entity.eye_video.CategoryBean
import com.cooleyepetizer.app.viewmodel.home.CategoryDetailViewModel
import com.gyf.immersionbar.ImmersionBar
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.activity_category_detail.*
import kotlinx.android.synthetic.main.activity_category_detail.refresh_layout

/**
 * @author fenghui
 * @date 2021/7/9.
 * @description 分类详情列表页面
 */
class CategoryDetailActivity : BaseMvvmRefreshActivity<ActivityCategoryDetailBinding,CategoryDetailViewModel>(){

    private val detailAdapter by lazy { CategoryDetailAdapter(this) }

    override fun onBindViewModel(): Class<CategoryDetailViewModel> {
        return CategoryDetailViewModel::class.java
    }

    override fun onBindLayout(): Int {
        return R.layout.activity_category_detail
    }

    override fun setStatusBar() {
        ImmersionBar.with(this)
            .titleBar(toolbar)
            .statusBarDarkFont(true)
            .init()
    }

    override fun initView() {
        isHideToolBar(true)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
        collapsing_toolbar_layout.setExpandedTitleColor(Color.WHITE) //设置还没收缩时状态下字体颜色
        collapsing_toolbar_layout.setCollapsedTitleTextColor(Color.BLACK) //设置收缩后Toolbar上字体的颜色
        refresh_layout.setEnableRefresh(false)
        rv_category.layoutManager = LinearLayoutManager(this)
        rv_category.adapter = detailAdapter
    }

    override fun initData() {
        val item: CategoryBean? = intent.getSerializableExtra(Constant.CATEGORY_INFO) as CategoryBean
        item?.let {
            mBinding?.category = it
            mViewModel?.getCategoryDetail(it.id)
        }
        mViewModel?.categoryList?.observe(this, Observer {
            if (mViewModel?.isLoadMore?.get()!!){
                detailAdapter?.addData(it)
            }else{
                detailAdapter?.setList(it)
            }
        })
    }

    override fun getRefreshLayout(): SmartRefreshLayout {
        return refresh_layout
    }

    override fun loadDataByLoadMore() {
        mViewModel?.loadMore()
    }

    override fun loadDataByRefresh() {

    }

}