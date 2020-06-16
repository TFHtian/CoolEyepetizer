package com.cooleyepetizer.app.fragment.community

import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.mvvm.BaseFragment
import com.cooleyepetizer.app.databinding.FragmentCommunityFollowBinding

class CommunityFollowFragment : BaseFragment<FragmentCommunityFollowBinding>(){

    override fun onBindLayout(): Int {
        return R.layout.fragment_community_follow
    }

    override fun initView() {
        isHideToolBar(true)
    }

    override fun initData() {

    }
}