package com.cooleyepetizer.lib

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.cooleyepetizer.app.BR
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ActivityBaseBindBinding
import kotlinx.android.synthetic.main.activity_base_bind.*

abstract class BaseBindActivity<T : ViewDataBinding, VM: ViewModel> : AppCompatActivity() {

    private lateinit var mRootBinding: ActivityBaseBindBinding

    private var mBinding: T? = null
    private var viewModel: VM? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRootBinding = DataBindingUtil.setContentView(this, R.layout.activity_base_bind)

        mBinding = DataBindingUtil.bind(LayoutInflater.from(this).inflate(initLayout(), null))
        container?.addView(mBinding!!.root, ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        ))
        viewModel = initViewModel()
        mBinding!!.setVariable(BR.viewModel, viewModel)

        initView()
    }

    @LayoutRes
    abstract fun initLayout(): Int

    abstract fun initView()

    open fun getBinding(): T? = mBinding

    open fun getViewModel(): VM? = viewModel

    open fun initViewModel(): VM? {
        return null
    }

}