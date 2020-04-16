package com.cooleyepetizer.app.activity.main

import androidx.fragment.app.Fragment
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.main.CustomTabAdaptervar
import com.cooleyepetizer.app.common_lib.mvvm.BaseActivity
import com.cooleyepetizer.app.databinding.ActivityMainBinding
import com.cooleyepetizer.app.fragment.*
import com.cooleyepetizer.app.fragment.home.HomeFragment
import com.jaeger.library.StatusBarUtil
import kotlinx.android.synthetic.main.activity_main.*
import me.majiajie.pagerbottomtabstrip.NavigationController
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem
import me.majiajie.pagerbottomtabstrip.item.NormalItemView
import java.util.ArrayList

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val fragmentList = ArrayList<Fragment>()
    private var navigationController: NavigationController? = null

    override fun initView() {
        isHideToolBar(true)
        fragmentList.add(HomeFragment())
        fragmentList.add(RecommendFragment())
        fragmentList.add(TheatreFragment())
        fragmentList.add(MineFragment())

        navigationController = main_tab.custom()
            .addItem(
                newItem(
                    R.drawable.home_n,
                    R.drawable.home_s,
                    this.resources.getString(R.string.bottom_title_homepage)
                )
            )
            .addItem(
                newItem(
                    R.drawable.find_n,
                    R.drawable.find_s,
                    this.resources.getString(R.string.bottom_title_recommend)
                )
            )
            .addItem(
                newItem(
                    R.drawable.culling_n,
                    R.drawable.culling_s,
                    this.resources.getString(R.string.bottom_title_theatre)
                )
            )
            .addItem(
                newItem(
                    R.drawable.my_n,
                    R.drawable.my_s,
                    this.resources.getString(R.string.bottom_title_personal)
                )
            )
            .build()

        main_view_page.adapter = CustomTabAdaptervar(fragmentList,supportFragmentManager)
        main_view_page.offscreenPageLimit = 3
        navigationController?.setupWithViewPager(main_view_page)
        navigationController?.setSelect(0)
    }

    override fun setStatusBar() {
        StatusBarUtil.setTranslucentForImageViewInFragment(this,0,null)
    }

    override fun initData() {}

    override fun onBindLayout(): Int {
        return R.layout.activity_main
    }

    /**
     * 创建一个Item
     */
    private fun newItem(drawable: Int, checkedDrawable: Int, text: String): BaseTabItem {
        val normalItemView = NormalItemView(this)
        normalItemView.initialize(drawable, checkedDrawable, text)
        normalItemView.setTextDefaultColor(this.resources.getColor(R.color.main_bottom_tv_n))
        normalItemView.setTextCheckedColor(this.resources.getColor(R.color.main_bottom_tv_s))
        return normalItemView
    }

}
