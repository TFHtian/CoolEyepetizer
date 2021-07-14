package com.cooleyepetizer.app.fragment.community

import android.graphics.Rect
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.community.CommunityRecommendAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmRefreshFragment
import com.cooleyepetizer.app.databinding.FragmentCommunityRecommendBinding
import com.cooleyepetizer.app.utils.CommonUtils
import com.cooleyepetizer.app.viewmodel.community.CommunityRecommendViewModel
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.fragment_community_recommend.*

class CommunityRecommendFragment : BaseMvvmRefreshFragment<FragmentCommunityRecommendBinding, CommunityRecommendViewModel>(){

    private val communityRecommendAdapter by lazy {activity?.let { CommunityRecommendAdapter(it) }  }

    override fun onBindViewModel(): Class<CommunityRecommendViewModel> {
        return CommunityRecommendViewModel::class.java
    }

    override fun onBindLayout(): Int {
        return R.layout.fragment_community_recommend
    }

    override fun getRefreshLayout(): SmartRefreshLayout {
        return refresh_layout
    }

    override fun initView() {
        isHideToolBar(true)
        val layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        layoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        community_recommend_list.adapter = communityRecommendAdapter
        community_recommend_list.layoutManager = layoutManager
        community_recommend_list.addItemDecoration(object : RecyclerView.ItemDecoration() {

            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                outRect.set(CommonUtils().dp2px(3f), 0,
                    CommonUtils().dp2px(3f)!!, CommonUtils().dp2px(15f)!!)
            }

        })
    }

    override fun initData() {
        mViewModel?.getCommunityRecommendData()
        mViewModel?.recommendList?.observe(this, Observer {
            if (mViewModel?.isLoadMore?.get()!!){
                communityRecommendAdapter?.addData(it)
            }else{
                communityRecommendAdapter?.setList(it)
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