package com.cooleyepetizer.app.test

import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ActivityPenBinding
import com.lpen.library.base.BaseActivity


/**
 * @author android_p
 * @date 2019/8/22
 */
class TestActivity : BaseActivity<ActivityPenBinding, TestViewModel>() {

    override fun getLayoutRes() = R.layout.activity_pen

    override fun initViewModel(): TestViewModel {
        val viewModel = ViewModelProviders.of(this)[TestViewModel::class.java]
        getBinding()?.viewModel = viewModel
        getBinding()?.listener = this
        return viewModel
    }

    override fun initView() {
        getViewModel()?.title?.set("测试一下")
        getViewModel()?.showBack?.set(false)
    }

    override fun onViewClick(v: View?) {
        super.onViewClick(v)
        when (v?.id) {
            R.id.txtKao -> {
                showLoading()
                v!!.postDelayed({
                    hideLoading()
                    getViewModel()?.desc?.set("我靠 ${(Math.random() * 10000).toInt()}")
                }, 2000)
            }
        }
    }

}