package com.cooleyepetizer.app.common_lib.mvvm

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.mvvm.view.IBaseView
import com.github.ybq.android.spinkit.style.Circle
import com.github.ybq.android.spinkit.style.ThreeBounce
import com.jaeger.library.StatusBarUtil
import kotlinx.android.synthetic.main.base_common_layout.*
import kotlinx.android.synthetic.main.common_toolbar.*
import kotlinx.android.synthetic.main.stub_init_loading.*
import kotlinx.android.synthetic.main.stub_trans_loading.*

abstract class BaseActivity : AppCompatActivity(), IBaseView {

    private var mContentView: ViewGroup? = null
    private var mViewStubInitLoading: Circle? = null
    private var mLoadingTransView: ThreeBounce? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_common_layout)
        initContentView()
        setStatusBar()
        initToolBar()
        initView()
        initListener()
        initData()
    }

    open fun initContentView() {
        setView(onBindLayout())
    }

    open fun setView(layoutId: Int) {
        mContentView = View.inflate(this, layoutId, null) as ViewGroup
        view_stub_content.removeAllViews()
        view_stub_content.addView(mContentView, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
    }

    private fun setStatusBar(){
        StatusBarUtil.setColor(this, resources.getColor(R.color.colorTheme), 0)
        setStatusTextBlack(true)
    }

    //6.0后设置状态栏字体颜色
    private fun setStatusTextBlack(isBlack: Boolean) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            if (isBlack) {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR//设置状态栏黑色字体
            } else {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE//恢复状态栏白色字体
            }
        }
    }

    private fun initToolBar(){
        setSupportActionBar(toolbar_root)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false)
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.icon_back)
        }
       // toolbar_root.setNavigationOnClickListener(View.OnClickListener { v -> onBackClick()})
    }

    open fun isHideToolBar(isHide : Boolean){
        if (isHide){
            toolbar_root.visibility = View.GONE
        }else{
            toolbar_root.visibility = View.VISIBLE
        }
    }

    //居中标题设置
    open fun setCenterTitle(text: CharSequence) {
        center_title.text = text
    }

    private fun onBackClick() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition()
        } else {
            onBackPressed()
        }
    }

    open fun showInitLoadView(show: Boolean) {
        Log.e("bbbbb","------$show")
        viewHide()
        if(mViewStubInitLoading==null){
            mViewStubInitLoading = Circle()
            mViewStubInitLoading!!.color = resources.getColor(R.color.textTitleColor)
        }
        if (show){
            Log.e("bbbbb","------2")
            view_stub_init_loading.visibility = View.VISIBLE
            view_stub_content.visibility = View.GONE
            iv_init_loading.setImageDrawable(mViewStubInitLoading)
            mViewStubInitLoading!!.start()
        } else{
            Log.e("bbbbb","------3")
            view_stub_init_loading.visibility = View.GONE
            view_stub_content.visibility = View.VISIBLE
            mViewStubInitLoading!!.stop()
        }
    }

    open fun showTransLoadingView(show: Boolean) {
        viewHide()
        if (mLoadingTransView==null){
            mLoadingTransView = ThreeBounce()
            mLoadingTransView!!.color = resources.getColor(R.color.textTitleColor)
        }
        if (show){
            view_stub_trans_loading.visibility = View.VISIBLE
            view_stub_content.visibility = View.GONE
            iv_trans_loading.setImageDrawable(mLoadingTransView)
            mLoadingTransView!!.start()
        }else{
            view_stub_trans_loading.visibility = View.GONE
            view_stub_content.visibility = View.VISIBLE
            mLoadingTransView!!.stop()
        }
    }

    open fun showNoDataView(show: Boolean) {
        viewHide()
        stopLoading()
        if (show){
            view_stub_no_data.visibility = View.VISIBLE
            view_stub_content.visibility = View.GONE
        }else{
            view_stub_no_data.visibility = View.GONE
            view_stub_content.visibility = View.VISIBLE
        }
    }

    open fun showNetWorkErrView(show: Boolean) {
        viewHide()
        stopLoading()
        if (show){
            view_stub_error.visibility = View.VISIBLE
            view_stub_content.visibility = View.GONE
        }else{
            view_stub_error.visibility = View.GONE
            view_stub_content.visibility = View.VISIBLE
        }
    }

    private fun viewHide(){
        view_stub_error.visibility = View.GONE
        view_stub_no_data.visibility = View.GONE
        view_stub_content.visibility = View.GONE
        view_stub_init_loading.visibility = View.GONE
        view_stub_trans_loading.visibility = View.GONE
    }

    private fun stopLoading(){
        if (mViewStubInitLoading!=null&&mViewStubInitLoading!!.isRunning){
            mViewStubInitLoading!!.stop()
        }
        if (mLoadingTransView!=null&&mLoadingTransView!!.isRunning){
            mLoadingTransView!!.stop()
        }
    }

    open abstract fun onBindLayout(): Int

    open abstract fun initView()

    open abstract fun initData()

    open abstract fun initListener()

    override fun finishActivity() {
        finish()
    }

    override fun getContext(): Context {
        return this
    }

    override fun onDestroy() {
        super.onDestroy()
        mViewStubInitLoading = null
        mLoadingTransView = null
    }

}

