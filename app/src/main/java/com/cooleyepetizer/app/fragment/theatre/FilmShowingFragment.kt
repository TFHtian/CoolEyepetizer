package com.cooleyepetizer.app.fragment.theatre

import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.mvvm.BaseFragment
import com.cooleyepetizer.app.databinding.FragmentFilmShowingBinding

class FilmShowingFragment : BaseFragment<FragmentFilmShowingBinding>(){

    override fun onBindLayout(): Int {
        return R.layout.fragment_film_showing
    }

    override fun initView() {
        isHideToolBar(true)
    }

    override fun initData() {
    }
}