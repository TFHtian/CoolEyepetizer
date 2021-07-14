package com.cooleyepetizer.app.fragment.community

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.community.CommunityFollowAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmRefreshFragment
import com.cooleyepetizer.app.databinding.FragmentCommunityFollowBinding
import com.cooleyepetizer.app.viewmodel.community.CommunityFollowViewModel
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.fragment_community_follow.*

class CommunityFollowFragment : BaseMvvmRefreshFragment<FragmentCommunityFollowBinding, CommunityFollowViewModel>(){

    private val followAdapter by lazy { activity?.let { CommunityFollowAdapter(it) } }

    override fun onBindViewModel(): Class<CommunityFollowViewModel> {
        return CommunityFollowViewModel::class.java
    }

    override fun onBindLayout(): Int {
        return R.layout.fragment_community_follow
    }

    override fun getRefreshLayout(): SmartRefreshLayout {
        return refresh_layout
    }

    override fun initView() {
        isHideToolBar(true)
        community_follow_list.layoutManager = LinearLayoutManager(activity)
        community_follow_list.adapter = followAdapter
    }

    override fun initData() {
        mViewModel?.getCommunityFollowData()
        mViewModel?.followList?.observe(this, Observer {
            if (mViewModel?.isLoadMore?.get()!!){
                followAdapter?.addData(it)
            }else{
                followAdapter?.setList(it)
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