package com.cooleyepetizer.app.test

import androidx.databinding.ObservableField
import com.lpen.library.base.AbsViewModel


/**
 * @author android_p
 * @date 2019/8/22
 */
class TestItemViewModel : AbsViewModel() {

    val avatar = ObservableField<String>()
    val nickName = ObservableField<String>()

}