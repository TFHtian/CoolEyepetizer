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
import androidx.fragment.app.Fragment
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.mvvm.view.IBaseView
import com.github.ybq.android.spinkit.style.Circle
import com.github.ybq.android.spinkit.style.ThreeBounce
import com.gyf.immersionbar.ImmersionBar
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import kotlinx.android.synthetic.main.base_common_layout.*
import kotlinx.android.synthetic.main.common_toolbar.*
import kotlinx.android.synthetic.main.stub_init_loading.*
import kotlinx.android.synthetic.main.stub_trans_loading.*

abstract class BaseFragment<DB : ViewDataBinding> : Fragment(), IBaseView {

    protected lateinit var mActivity: RxAppCompatActivity
    private lateinit var mView: View
    private var mStubInitLoading: Circle? = null
    private var mTransVLoading: ThreeBounce? =null
    private var stubInitLoadingView: View? = null
    private var transVLoadingView: View? = null
    private var netErrorView: View? = null
    private var noDataView: View? = null
    private var isViewCreated = false
    private var isViewVisible = false
    protected var mBinding: DB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = (activity as RxAppCompatActivity?)!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.base_common_layout, container, false)
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initContentView()
        setStatusBar()
        initToolBar()
        initView()
        isViewCreated = true
        //如果启用了懒加载就进行懒加载，否则就进行预加载
        if (enableLazyData()) {
            lazyLoad()
        } else {
            initData()
        }
    }

    open fun initContentView() {
        mBinding = DataBindingUtil.bind(LayoutInflater.from(mActivity).inflate(onBindLayout(), null))
        content?.addView(mBinding!!.root, ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        ))
    }

    open fun setStatusBar(){
        ImmersionBar.with(this)
            .titleBar(toolbar_root)
            .keyboardEnable(false)
            .statusBarDarkFont(true)
            .init()
    }

    //6.0后设置状态栏字体颜色
    private fun setStatusTextBlack(isBlack: Boolean) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            if (isBlack) {
                mActivity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR//设置状态栏黑色字体
            } else {
                mActivity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE//恢复状态栏白色字体
            }
        }
    }

    private fun initToolBar(){
        mActivity.setSupportActionBar(toolbar_root)
        val actionBar = mActivity.supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false)
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.icon_back)
        }
        toolbar_root.setNavigationOnClickListener { activity?.finish() }
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

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        isViewVisible = isVisibleToUser
        //如果启用了懒加载就进行懒加载，
        if (enableLazyData() && isViewVisible) {
            lazyLoad()
        }
    }

    private fun lazyLoad() {
        //这里进行双重标记判断,必须确保onCreateView加载完毕且页面可见,才加载数据
        if (isViewCreated && isViewVisible) {
            initData()
            //数据加载完毕,恢复标记,防止重复加载
            isViewCreated = false
            isViewVisible = false
        }
    }

    //默认不启用懒加载
    private fun enableLazyData(): Boolean {
        return true
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
            mStubInitLoading!!.stop()
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
            mTransVLoading!!.stop()
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

    open abstract fun onBindLayout(): Int

    open abstract fun initView()

    open abstract fun initData()

    override fun finishActivity() {}

    override fun getContext(): Context {
        return mActivity
    }

}