package com.lpen.library.listener

import android.view.View
import com.lpen.library.base.AbsViewModel


/**
 * @author android_p
 * @date 2019/8/22
 */
interface OnViewModelClickListener<VM : AbsViewModel> {

    fun onClick(v: View?, model: VM)

}