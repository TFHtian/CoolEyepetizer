package com.lpen.library.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.lpen.library.R
import com.lpen.library.databinding.AbsActivityBaseBinding
import com.lpen.library.listener.OnBindClickListener
import kotlinx.android.synthetic.main.abs_activity_base.*


/**
 * @author android_p
 * @date 2019/8/22
 */
abstract class BaseActivity<DB: ViewDataBinding, VM : BaseViewModel> : AppCompatActivity(), OnBindClickListener {

    private var mBinding: DB? = null
    private var mViewModel: VM? = null

    private var mLoadingDialog: LoadingDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<AbsActivityBaseBinding>(this, R.layout.abs_activity_base)
        setStatusBarIconColor(true)
        val sonView = LayoutInflater.from(this).inflate(getLayoutRes(), null)
        container.addView(sonView)
        mBinding = DataBindingUtil.bind(sonView)
        mViewModel = initViewModel()
        binding?.viewModel = mViewModel
        binding?.listener = this
        initView()
    }

    abstract fun getLayoutRes(): Int

    protected abstract fun initViewModel(): VM


    protected abstract fun initView()

    protected fun getBinding() = mBinding
    protected fun getViewModel() = mViewModel

    protected fun showLoading(txt: String? = "") {
        if (mLoadingDialog == null) {
            mLoadingDialog = LoadingDialog(this, txt)
        } else {
            mLoadingDialog!!.setLoadingTips(txt)
            mLoadingDialog?.cancel()
        }
        mLoadingDialog!!.show()
    }

    protected fun hideLoading() {
        mLoadingDialog?.cancel()
    }

    override fun onViewClick(v: View?) {
        when (v?.id) {
            R.id.imgBack -> {
                onBackPressed()
            }
            R.id.imgMenu -> {
                onImgMenuClick()
            }
            R.id.txtMenu -> {
                onTxtMenuClick()
            }
        }
    }

    /**
     * 图标菜单按钮点击事件
     */
    protected fun onImgMenuClick() {

    }

    /**
     * 文本菜单按钮点击事件
     */
    protected fun onTxtMenuClick() {

    }

}