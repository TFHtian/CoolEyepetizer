package com.cooleyepetizer.app.test

import android.view.View
import com.cooleyepetizer.app.R
import com.lpen.library.base.BaseAdapter
import com.cooleyepetizer.app.databinding.ItemTestBinding
import com.lpen.library.listener.OnViewModelClickListener
import com.lpen.library.utils.ImgLoadUtil

/**
 * @author android_p
 * @date 2019/8/22
 */
class TestAdapter : BaseAdapter<ItemTestBinding, TestItemViewModel>(R.layout.item_test) {

    private var mListener: OnViewModelClickListener<TestItemViewModel>? = null

    override fun onConvert(binding: ItemTestBinding, model: TestItemViewModel) {
        ImgLoadUtil.loadCircleImg(mContext, model.avatar.get(), binding.imgAvatar)

        binding.itemListener = object : OnViewModelClickListener<TestItemViewModel> {
            override fun onClick(v: View?, model: TestItemViewModel) {
                mListener?.onClick(v, model)
            }
        }
    }

    fun addOnItemClickListener(listener: OnViewModelClickListener<TestItemViewModel>?) {
        mListener = listener
    }

}