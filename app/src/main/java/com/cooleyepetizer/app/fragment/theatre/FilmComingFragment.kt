package com.cooleyepetizer.app.fragment.theatre

import android.graphics.Rect
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.theatre.FilmComingAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmRefreshFragment
import com.cooleyepetizer.app.databinding.FragmentFilmComingBinding
import com.cooleyepetizer.app.utils.CommonUtils
import com.cooleyepetizer.app.viewmodel.theatre.FilmComingViewModel
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.fragment_film_coming.*

class FilmComingFragment : BaseMvvmRefreshFragment<FragmentFilmComingBinding, FilmComingViewModel>(){

    private val filmComingAdapter by lazy { FilmComingAdapter() }

    override fun onBindLayout(): Int {
        return R.layout.fragment_film_coming
    }

    override fun getRefreshLayout(): SmartRefreshLayout {
        return refresh_layout
    }

    override fun onBindViewModel(): Class<FilmComingViewModel> {
        return FilmComingViewModel::class.java
    }

    override fun initView() {
        isHideToolBar(true)
        film_coming_list.layoutManager = GridLayoutManager(activity,2)
        film_coming_list.adapter = filmComingAdapter
        film_coming_list.addItemDecoration(object : RecyclerView.ItemDecoration() {

            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                val position = parent.getChildPosition(view)
                val offset = CommonUtils().dp2px(3f)!!

                outRect.set(if (position % 2 == 0) 0 else offset, offset,
                    if (position % 2 == 0) offset else 0, offset)
            }

        })
    }

    override fun initData() {
        mViewModel?.getFilmComingData()
        mViewModel?.filmComingList?.observe(this, Observer {
            filmComingAdapter.setList(it)
        })
    }

    override fun loadDataByRefresh() {

    }

    override fun loadDataByLoadMore() {

    }


}