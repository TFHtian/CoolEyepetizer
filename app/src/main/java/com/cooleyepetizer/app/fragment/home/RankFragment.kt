package com.cooleyepetizer.app.fragment.home

import android.os.Bundle
import androidx.lifecycle.Observer
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.home.RankListAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmFragment
import com.cooleyepetizer.app.databinding.FragmentRankBinding
import com.cooleyepetizer.app.utils.CommonUtils
import com.cooleyepetizer.app.view.StackCardLayoutManager
import com.cooleyepetizer.app.viewmodel.home.RankViewModel
import kotlinx.android.synthetic.main.fragment_rank.*


class RankFragment : BaseMvvmFragment<FragmentRankBinding,RankViewModel>(){

    private var apiUrl: String? = null
    private val rankAdapter by lazy { activity?.let { RankListAdapter() } }

    companion object {
        fun getInstance(apiUrl: String): RankFragment {
            val fragment = RankFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.apiUrl = apiUrl
            return fragment
        }
    }

    override fun onBindViewModel(): Class<RankViewModel> {
        return RankViewModel::class.java
    }

    override fun onBindLayout(): Int {
        return R.layout.fragment_rank
    }

    override fun initView() {
        isHideToolBar(true)
        rank_list.adapter = rankAdapter
        val verticalConfig = StackCardLayoutManager.StackConfig()
        verticalConfig.stackScale = 0.9f
        verticalConfig.stackCount = 3
        verticalConfig.stackPosition = 0
        verticalConfig.space = CommonUtils().dp2px(24f)
        verticalConfig.parallex = 1.5f
        verticalConfig.isCycle = true
        verticalConfig.isAutoCycle = false
        //verticalConfig.autoCycleTime = 3500
        verticalConfig.direction = StackCardLayoutManager.StackDirection.RIGHT
        rank_list.layoutManager = StackCardLayoutManager(verticalConfig)
    }

    override fun initData() {
        mViewModel?.getIssueData(apiUrl!!)
        mViewModel?.rankList?.observe(this, Observer {

            rankAdapter?.setList(it)
        })
    }
}