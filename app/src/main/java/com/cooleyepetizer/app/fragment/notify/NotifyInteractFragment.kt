package com.cooleyepetizer.app.fragment.notify

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.notify.NotifyInteractAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmRefreshFragment
import com.cooleyepetizer.app.databinding.FragmentNotifyInteractBinding
import com.cooleyepetizer.app.viewmodel.notify.NotifyInteractViewModel
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.fragment_notify_interact.*

class NotifyInteractFragment : BaseMvvmRefreshFragment<FragmentNotifyInteractBinding,NotifyInteractViewModel>(){

    private val interactArray by lazy { NotifyInteractAdapter() }

    override fun onBindViewModel(): Class<NotifyInteractViewModel> {
        return NotifyInteractViewModel::class.java
    }

    override fun onBindLayout(): Int {
        return R.layout.fragment_notify_interact
    }

    override fun getRefreshLayout(): SmartRefreshLayout {
        return refresh_layout
    }

    override fun initView() {
        isHideToolBar(true)
        notify_interact_list.layoutManager = LinearLayoutManager(mActivity)
        notify_interact_list.adapter = interactArray
    }

    override fun initData() {
        mViewModel?.getNotifyInteractData()
        mViewModel?.interactList?.observe(this, Observer {
            interactArray.setList(it)
        })
    }

    override fun loadDataByRefresh() {

    }

    override fun loadDataByLoadMore() {

    }

}