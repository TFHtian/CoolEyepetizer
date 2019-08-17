package com.cooleyepetizer.app.common_lib.mvvm

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.mvvm.view.IBaseView
import com.github.ybq.android.spinkit.style.Circle
import com.github.ybq.android.spinkit.style.ThreeBounce
import com.jaeger.library.StatusBarUtil
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import kotlinx.android.synthetic.main.base_common_layout.*
import kotlinx.android.synthetic.main.common_toolbar.*
import kotlinx.android.synthetic.main.stub_init_loading.*
import kotlinx.android.synthetic.main.stub_trans_loading.*

abstract class BaseFragment : androidx.fragment.app.Fragment(), IBaseView {

    private lateinit var mActivity: RxAppCompatActivity
    private lateinit var mView: View
    private var mContentView: ViewGroup? = null
    private var mViewStubInitLoading: Circle? = null
    private var mLoadingTransView: ThreeBounce? =null
    private var isViewCreated = false
    private var isViewVisible = false

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
        initListener()
        isViewCreated = true
        //如果启用了懒加载就进行懒加载，否则就进行预加载
        if (enableLazyData()) {
            lazyLoad()
        } else {
            initData()
        }
    }

    open fun initContentView() {
        setView(onBindLayout())
    }

    private fun setView(layoutId: Int) {
        mContentView = View.inflate(mActivity, layoutId, null) as ViewGroup
        view_stub_content.removeAllViews()
        view_stub_content.addView(mContentView, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
    }

    private fun setStatusBar(){
        StatusBarUtil.setColor(mActivity, resources.getColor(R.color.colorTheme), 0)
        setStatusTextBlack(true)
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
        return false
    }

    open fun showInitLoadView(show: Boolean) {
        viewHide()
        if(mViewStubInitLoading==null){
            mViewStubInitLoading = Circle()
            mViewStubInitLoading!!.color = resources.getColor(R.color.textTitleColor)
        }
        if (show){
            view_stub_init_loading.visibility = View.VISIBLE
            view_stub_content.visibility = View.GONE
            iv_init_loading.setImageDrawable(mViewStubInitLoading)
            mViewStubInitLoading!!.start()
        }else{
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

    open fun initListener() {

    }

    override fun finishActivity() {

    }

    override fun getContext(): Context {
        return mActivity
    }

}