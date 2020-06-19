package com.cooleyepetizer.app.fragment.home

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.home.HomeListAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmFragment
import com.cooleyepetizer.app.databinding.FragmentRankBinding
import com.cooleyepetizer.app.viewmodel.home.RankViewModel
import kotlinx.android.synthetic.main.fragment_rank.*

class RankFragment : BaseMvvmFragment<FragmentRankBinding,RankViewModel>(){

    private var apiUrl: String? = null
    private val rankAdapter by lazy { activity?.let { HomeListAdapter() } }

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

        rank_list.layoutManager = LinearLayoutManager(mActivity)
    }

    override fun initData() {
        mViewModel?.getRankListData(apiUrl!!)
        mViewModel?.rankList?.observe(this, Observer {
            rankAdapter?.setList(it)
        })
    }
}