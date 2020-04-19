package com.cooleyepetizer.app.activity.place

import android.content.Intent
import android.util.Log
import android.view.View
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.activity.main.MainActivity
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmActivity
import com.cooleyepetizer.app.databinding.ActivityTextBinding
import com.cooleyepetizer.app.viewmodel.PlaceViewModel
import com.cooleyepetizer.app.listener.OnViewClickListener

class TextActivity : BaseMvvmActivity<ActivityTextBinding, PlaceViewModel>() {

    override fun onBindViewModel(): Class<PlaceViewModel> {
        return PlaceViewModel::class.java
    }

    override fun onBindLayout(): Int {
        return R.layout.activity_text
    }

    override fun initView() {
        setCenterTitle("测试")
        mBinding?.model = mViewModel
        mViewModel?.createUser()
        //mViewModel?.getPlace(this)
        Log.e("ddddddddd","${mViewModel?.user!!.get()?.name}")
        val intent = Intent(this,MainActivity::class.java)
        mBinding?.listener = object :
            OnViewClickListener {
            override fun onClick(v: View) {
                mViewModel?.updateName()
                startActivity(intent)
            }
        }
    }
}
