package com.cooleyepetizer.app.fragment.home

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.home.HomeListAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmFragment
import com.cooleyepetizer.app.databinding.FragmentHomeFindBinding
import com.cooleyepetizer.app.viewmodel.home.HomeFindViewModel
import kotlinx.android.synthetic.main.fragment_home_find.*

class HomeFindFragment : BaseMvvmFragment<FragmentHomeFindBinding,HomeFindViewModel>(){

    private val findAdapter by lazy { HomeListAdapter() }

    override fun onBindLayout(): Int {
        return R.layout.fragment_home_find
    }

    override fun onBindViewModel(): Class<HomeFindViewModel> {
        return HomeFindViewModel::class.java
    }

    override fun initView() {
        isHideToolBar(true)
        home_find_list.adapter = findAdapter
        home_find_list.layoutManager = LinearLayoutManager(activity)
    }

    override fun initData() {
        mViewModel?.getHomeFindData()
        mViewModel?.findList?.observe(this, Observer {
            findAdapter.setList(it)
        })
    }

}