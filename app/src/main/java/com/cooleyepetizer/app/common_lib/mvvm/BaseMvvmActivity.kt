package com.cooleyepetizer.app.common_lib.mvvm

import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.cooleyepetizer.app.BR

abstract class BaseMvvmActivity<DB : ViewDataBinding,  VM : BaseViewModel> : BaseActivity() {

    var mBinding: DB? = null
    var mViewModel: VM? = null

    override fun initContentView() {
        super.initContentView()

        // TODO 顺序有问题， initView  initData 在 DataBiding 之前， 子类重写 initView 中 mViewModel 这些为 null
        initViewDataBinding()
        initBaseViewObservable()

        onInit()
    }

    protected abstract fun onInit()

    protected abstract fun initViewModel(): VM

    private fun initViewDataBinding() {
        val sonView = LayoutInflater.from(this).inflate(onBindLayout(),null)
        mBinding = DataBindingUtil.bind(sonView)
        // TODO 靠， initViewModel 不调用，子类实现有屁用
        mViewModel = initViewModel()
        // TODO 此处的 绑定是否要加按照需求来，一般放在子类 绑定 viewModel
//        mBinding?.setVariable(BR.viewModel, mViewModel)
    }

    private fun initBaseViewObservable() {
        mViewModel?.absLiveData?.observe(this, Observer {
            Log.e("Test", "LiveData 鸡肋回调 ---- $it")
        }) ?: Log.e("Test", "空")
    }

}