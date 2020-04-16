package com.cooleyepetizer.app.common_lib.mvvm

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.mvvm.view.IBaseView
import com.cooleyepetizer.app.databinding.BaseCommonLayoutBinding
import com.github.ybq.android.spinkit.style.Circle
import com.github.ybq.android.spinkit.style.ThreeBounce
import com.jaeger.library.StatusBarUtil
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import kotlinx.android.synthetic.main.base_common_layout.*
import kotlinx.android.synthetic.main.common_toolbar.*
import kotlinx.android.synthetic.main.stub_init_loading.*
import kotlinx.android.synthetic.main.stub_trans_loading.*

abstract class BaseActivity<DB : ViewDataBinding> : RxAppCompatActivity(), IBaseView {

    private var mStubInitLoading: Circle? = null
    private var mTransVLoading: ThreeBounce? =null
    private var stubInitLoadingView: View? = null
    private var transVLoadingView: View? = null
    private var netErrorView: View? = null
    private var noDataView: View? = null
    private lateinit var mBaseBinding : BaseCommonLayoutBinding
    protected var mBinding: DB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBaseBinding = DataBindingUtil.setContentView(this, R.layout.base_common_layout)
        initContentView()
        setStatusBar()
        initToolBar()
        initView()
        initData()
    }

    open fun initContentView() {
        mBinding = DataBindingUtil.bind(LayoutInflater.from(this).inflate(onBindLayout(), null))
        content?.addView(mBinding!!.root, ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        ))
    }

    open fun setStatusBar(){
        StatusBarUtil.setColor(this, resources.getColor(R.color.colorThemeBg), 0)
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
        if(mStubInitLoading==null){
            mStubInitLoading = Circle()
            mStubInitLoading!!.color = resources.getColor(R.color.textTitleColor)
        }
        if (stubInitLoadingView == null) {
            stubInitLoadingView = view_stub_init_loading.inflate()
        }
        stubInitLoadingView?.visibility = if (show) View.VISIBLE else View.GONE
        mBinding!!.root.visibility = if (show) View.GONE else View.VISIBLE
        if (show){
            iv_init_loading.setImageDrawable(mStubInitLoading)
            mStubInitLoading!!.start()
        } else{
            Handler().postDelayed(Runnable {
                mStubInitLoading!!.stop()
            },500)
        }
    }

    open fun showTransLoadingView(show: Boolean) {
        if (mTransVLoading==null){
            mTransVLoading = ThreeBounce()
            mTransVLoading!!.color = resources.getColor(R.color.textTitleColor)
        }
        if(transVLoadingView == null){
            transVLoadingView = view_stub_trans_loading.inflate()
        }
        transVLoadingView?.visibility = if (show) View.VISIBLE else View.GONE
        mBinding!!.root.visibility = if (show) View.GONE else View.VISIBLE
        if (show){
            iv_trans_loading.setImageDrawable(mTransVLoading)
            mTransVLoading!!.start()
        }else{
            Handler().postDelayed(Runnable {
                mTransVLoading!!.stop()
            },500)
        }
    }

    open fun showNoDataView(show: Boolean) {
        stopLoading()
        if (noDataView == null){
            noDataView = view_stub_no_data.inflate()
        }
        noDataView?.visibility = if (show) View.VISIBLE else View.GONE
        mBinding!!.root.visibility = if (show) View.GONE else View.VISIBLE
    }

    open fun showNetWorkErrView(show: Boolean) {
        stopLoading()
        if (netErrorView == null){
            netErrorView = view_stub_error.inflate()
        }
        netErrorView?.visibility = if (show) View.VISIBLE else View.GONE
        mBinding!!.root.visibility = if (show) View.GONE else View.VISIBLE
    }

    private fun stopLoading(){
        if (mStubInitLoading!=null&&mStubInitLoading!!.isRunning){
            mStubInitLoading!!.stop()
        }
        if (mTransVLoading!=null&&mTransVLoading!!.isRunning){
            mTransVLoading!!.stop()
        }
    }

    abstract fun onBindLayout(): Int

    abstract fun initView()

    abstract fun initData()

    override fun finishActivity() {
        finish()
    }

    override fun getContext(): Context {
        return this
    }

    override fun onDestroy() {
        super.onDestroy()
        mStubInitLoading = null
        mTransVLoading = null
    }
}

