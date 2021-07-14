package com.cooleyepetizer.app.viewmodel.community

import com.cooleyepetizer.app.common_lib.mvvm.BaseViewModel
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean

class CommRecActViewModel : BaseViewModel(){

    var dataList: List<EyeListItemBean>? = null

    var itemPosition: Int = -1

}