package com.cooleyepetizer.app.fragment.notify

import android.content.Intent
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.activity.home.CategoryDetailActivity
import com.cooleyepetizer.app.activity.home.TopicDetailActivity
import com.cooleyepetizer.app.adapter.notify.NotifyInteractAdapter
import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.common_lib.config.Constant
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmRefreshFragment
import com.cooleyepetizer.app.databinding.FragmentNotifyInteractBinding
import com.cooleyepetizer.app.entity.notify.NotifyInteractItemBean
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
        interactArray.setOnItemClickListener { adapter, _, position ->
            val item: NotifyInteractItemBean = adapter.getItem(position) as NotifyInteractItemBean
            val intent = Intent(activity, TopicDetailActivity::class.java)
            intent.putExtra(Constant.ID,item.data.id)
            activity?.startActivity(intent)
        }
    }

    override fun initData() {
        mViewModel?.getNotifyInteractData()
        mViewModel?.interactList?.observe(this, Observer {
            if (mViewModel?.isLoadMore?.get()!!){
                interactArray?.addData(it)
            }else{
                interactArray?.setList(it)
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