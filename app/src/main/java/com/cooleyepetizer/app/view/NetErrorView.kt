package com.cooleyepetizer.app.view

import android.content.Context
import androidx.annotation.ColorRes
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.cooleyepetizer.app.R
import kotlinx.android.synthetic.main.view_no_data.view.*

class NetErrorView(context: Context?, attrs: AttributeSet?) : RelativeLayout(context, attrs) {

    init {
        View.inflate(context, R.layout.view_no_data,this)
    }

    fun setNetErrorBackground(@ColorRes colorResId: Int) {
        rl_no_data_root.setBackgroundColor(resources.getColor(colorResId))
    }

}