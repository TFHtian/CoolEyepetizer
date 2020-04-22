package com.cooleyepetizer.app.view

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.cooleyepetizer.app.R
import com.github.ybq.android.spinkit.style.Circle
import com.scwang.smartrefresh.layout.api.RefreshHeader
import com.scwang.smartrefresh.layout.api.RefreshKernel
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.constant.RefreshState
import com.scwang.smartrefresh.layout.constant.SpinnerStyle
import kotlinx.android.synthetic.main.eye_refresh_head.view.*

class EyeRefreshHead(context: Context) :LinearLayout(context), RefreshHeader{

    private var mStubInitLoading: Circle? = null

//    init {
//        mStubInitLoading = Circle()
//        mStubInitLoading!!.color = resources.getColor(R.color.textTitleColor)
//    }

    override fun getSpinnerStyle(): SpinnerStyle {
        return SpinnerStyle.Translate
    }

    override fun getView(): View {
        return this
    }

    override fun onStartAnimator(refreshLayout: RefreshLayout, height: Int, maxDragHeight: Int) {
        //mStubInitLoading!!.start()
        aiv.show()
    }

    override fun onStateChanged(
        refreshLayout: RefreshLayout,
        oldState: RefreshState,
        newState: RefreshState
    ) {
        when (newState) {
            RefreshState.None, RefreshState.PullDownToRefresh -> {
                //im_refresh_header.visibility = View.VISIBLE
                tv_refresh_header.text = "下拉开始刷新"
                //im_refresh_header.setImageDrawable(mStubInitLoading)
                //mStubInitLoading!!.start()
                aiv.show()
            }
            RefreshState.Refreshing -> {
                //im_refresh_header.visibility = View.VISIBLE
                tv_refresh_header.text = "正在刷新数据"
                //im_refresh_header.setImageDrawable(mStubInitLoading)
                //mStubInitLoading!!.start()
                aiv.show()
            }
            RefreshState.ReleaseToRefresh -> {
                //im_refresh_header.visibility = View.VISIBLE
                tv_refresh_header.text = "释放立即刷新"
                //im_refresh_header.setImageDrawable(mStubInitLoading)
                //mStubInitLoading!!.start()
                aiv.show()
            }
        }
    }

    override fun onFinish(refreshLayout: RefreshLayout, success: Boolean): Int {
        if (success) {
            im_refresh_header.visibility = View.GONE
            tv_refresh_header.text = "刷新完成"
        } else {
            tv_refresh_header.text = "刷新失败"
            im_refresh_header.visibility = View.GONE
        }
//        if (mStubInitLoading != null) {
//            mStubInitLoading!!.stop()
//        }
        aiv.hide()
        return 500
    }

    override fun onInitialized(kernel: RefreshKernel, height: Int, maxDragHeight: Int) {

    }

    override fun onHorizontalDrag(percentX: Float, offsetX: Int, offsetMax: Int) {

    }

    override fun onReleased(refreshLayout: RefreshLayout, height: Int, maxDragHeight: Int) {

    }

    override fun setPrimaryColors(vararg colors: Int) {

    }

    override fun onMoving(
        isDragging: Boolean,
        percent: Float,
        offset: Int,
        height: Int,
        maxDragHeight: Int
    ) {

    }

    override fun isSupportHorizontalDrag(): Boolean {
        return false
    }


}