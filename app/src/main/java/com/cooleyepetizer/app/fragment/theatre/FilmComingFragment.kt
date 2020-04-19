package com.cooleyepetizer.app.fragment.theatre

import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.common_lib.mvvm.BaseFragment
import com.cooleyepetizer.app.databinding.FragmentFilmComingBinding

class FilmComingFragment : BaseFragment<FragmentFilmComingBinding>(){
    override fun onBindLayout(): Int {
        return R.layout.fragment_film_coming
    }

    override fun initView() {
        isHideToolBar(true)
    }

    override fun initData() {
    }
}