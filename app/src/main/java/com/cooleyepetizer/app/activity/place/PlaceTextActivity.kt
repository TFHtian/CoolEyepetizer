package com.cooleyepetizer.app.activity.place

import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ActivityTextMvvmBinding
import com.cooleyepetizer.app.entity.place.User
import com.cooleyepetizer.app.viewmodel.PlaceViewModel
import com.cooleyepetizer.lib.BaseBindActivity
import com.cooleyepetizer.lib.OnViewClickListener

class PlaceTextActivity : BaseBindActivity<ActivityTextMvvmBinding, PlaceViewModel>() {

    override fun initViewModel(): PlaceViewModel? {
        return ViewModelProviders.of(this)[PlaceViewModel::class.java]
    }

    override fun initLayout() = R.layout.activity_text_mvvm

    override fun initView() {
        getViewModel()?.getPlace(this)
        getViewModel()?.createUser()

        var user = User("甜甜","女")
        getBinding()?.u = user

        getBinding()?.listener = object : OnViewClickListener {
            override fun onClick(v: View) {
                getViewModel()?.updateName()
            }
        }

    }

}