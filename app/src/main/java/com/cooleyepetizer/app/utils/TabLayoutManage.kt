package com.cooleyepetizer.app.utils

import android.graphics.Typeface
import androidx.viewpager.widget.ViewPager
import com.flyco.tablayout.SlidingTabLayout

/**
 * tab_layout样式设置
 */
class TabLayoutManage {

    companion object{

        /**
         * 设置字体大小与样式
         */
        fun topTabTextStyle(vp: ViewPager,tabLayout: SlidingTabLayout){
            vp.currentItem = 0//设置首个被选中
            tabLayout.getTitleView(0).typeface = Typeface.DEFAULT_BOLD
            tabLayout.getTitleView(0).textSize = 15f//设置首个文字的大小
            vp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
                override fun onPageScrollStateChanged(state: Int) {

                }

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {

                }

                override fun onPageSelected(position: Int) {
                    var nubs = 0 until tabLayout.tabCount
                    for(n in nubs) {
                        if (position == n){
                            //选中的文字
                            tabLayout.getTitleView(n).textSize = 15f
                        }else{
                            //未选中的文字，并且设置未选中时的不加粗
                            tabLayout.getTitleView(n).textSize = 13f
                            tabLayout.getTitleView(0).typeface = Typeface.DEFAULT
                        }
                    }
                }
            })
        }
    }

}