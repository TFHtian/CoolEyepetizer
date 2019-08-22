package com.cooleyepetizer.app.test

import androidx.databinding.ObservableField
import com.lpen.library.base.BaseViewModel


/**
 * @author android_p
 * @date 2019/8/22
 */
class TestViewModel : BaseViewModel() {

    val desc = ObservableField<String>("测试")

}