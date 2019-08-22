package com.lpen.library.base

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lpen.library.BR


/**
 * @author android_p
 * @date 2019/8/22
 */
abstract class BaseAdapter<DB : ViewDataBinding, VM : AbsViewModel>(layoutId: Int) :
    BaseQuickAdapter<VM, BaseViewHolder>(layoutId) {

    override fun convert(helper: BaseViewHolder?, item: VM?) {
        helper?.itemView?.let { view ->
            DataBindingUtil.bind<DB>(view)?.let { binding ->
                if (item != null) {
                    binding.setVariable(BR.viewModel, item)
                    onConvert(binding, item)
                }
            }
        }
    }

    abstract fun onConvert(binding: DB, model: VM)

    override fun setNewData(data: MutableList<VM>?) {
        super.setNewData(data)
        if (recyclerView != null) {     // need bind recyclerView first
            disableLoadMoreIfNotFullPage()
        }
    }

}