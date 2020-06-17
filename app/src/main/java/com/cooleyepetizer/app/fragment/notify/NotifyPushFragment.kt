package com.cooleyepetizer.app.fragment.notify

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.notify.NotifyPushAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmRefreshFragment
import com.cooleyepetizer.app.databinding.FragmentNotifyPushBinding
import com.cooleyepetizer.app.viewmodel.notify.NotifyPushViewModel
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.fragment_notify_push.*

class NotifyPushFragment : BaseMvvmRefreshFragment<FragmentNotifyPushBinding,NotifyPushViewModel>(){

    private val pushAdapter by lazy { NotifyPushAdapter() }

    override fun onBindLayout(): Int {
        return R.layout.fragment_notify_push
    }

    override fun getRefreshLayout(): SmartRefreshLayout {
        return refresh_layout
    }

    override fun onBindViewModel(): Class<NotifyPushViewModel> {
        return NotifyPushViewModel::class.java
    }

    override fun initView() {
        isHideToolBar(true)
        notify_push_list.layoutManager = LinearLayoutManager(activity)
        notify_push_list.adapter = pushAdapter
    }

    override fun initData() {
        mViewModel?.getNotifyPushData()
        mViewModel?.pushList?.observe(this, Observer {
            if (mViewModel?.isLoadMore?.get()!!){
                pushAdapter?.addData(it)
            }else{
                pushAdapter.setList(it)
            }
        })
    }

    override fun loadDataByRefresh() {
        mViewModel?.refresh()
    }

    override fun loadDataByLoadMore() {
        mViewModel?.loadMore()
    }

}