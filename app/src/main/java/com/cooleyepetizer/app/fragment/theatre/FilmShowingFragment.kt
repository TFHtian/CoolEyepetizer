package com.cooleyepetizer.app.fragment.theatre

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.theatre.FilmShowingAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseFragment
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmRefreshFragment
import com.cooleyepetizer.app.databinding.FragmentFilmShowingBinding
import com.cooleyepetizer.app.viewmodel.theatre.FilmShowingViewModel
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.fragment_film_showing.*

class FilmShowingFragment : BaseMvvmRefreshFragment<FragmentFilmShowingBinding, FilmShowingViewModel>(){

    private val filmShowingAdapter by lazy { FilmShowingAdapter() }

    override fun onBindLayout(): Int {
        return R.layout.fragment_film_showing
    }

    override fun getRefreshLayout(): SmartRefreshLayout {
        return refresh_layout
    }

    override fun onBindViewModel(): Class<FilmShowingViewModel> {
        return FilmShowingViewModel::class.java
    }

    override fun initView() {
        isHideToolBar(true)
        film_showing_list.layoutManager = LinearLayoutManager(activity)
        film_showing_list.adapter = filmShowingAdapter
    }

    override fun initData() {
        mViewModel?.getFilmShowingData()
        mViewModel?.filmShowingList?.observe(this, Observer {
            filmShowingAdapter.setList(it)
        })
    }

    override fun loadDataByRefresh() {

    }

    override fun loadDataByLoadMore() {

    }


}