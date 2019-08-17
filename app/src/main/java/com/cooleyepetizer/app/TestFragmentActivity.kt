package com.cooleyepetizer.app

import androidx.fragment.app.FragmentTransaction
import com.cooleyepetizer.app.common_lib.mvvm.BaseActivity
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.activity_test.*
import java.util.ArrayList

class TestFragmentActivity : BaseActivity() {

    private val mTitles = arrayOf("首页","我的")

    private var mHomeFragment: HomeFragment? = null
    private var mMineFragment: MineFragment? = null

    private val mTabEntities = ArrayList<CustomTabEntity>()

    // 未被选中的图标
    private val mIconUnSelectIds = intArrayOf(R.drawable.home_n, R.drawable.my_n)
    // 被选中的图标
    private val mIconSelectIds = intArrayOf(R.drawable.home_s, R.drawable.my_s)

    override fun onBindLayout(): Int {
        return R.layout.activity_test
    }

    override fun initView() {
        isHideToolBar(true)
        initTab()
    }

    override fun initData() {

    }

    //初始化底部菜单
    private fun initTab() {
        (0 until mTitles.size)
                .mapTo(mTabEntities) { TabEntity(mTitles[it], mIconSelectIds[it], mIconUnSelectIds[it]) }
        //为Tab赋值
        tab_layout.setTabData(mTabEntities)
        tab_layout.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                //切换Fragment
                switchFragment(position)
            }

            override fun onTabReselect(position: Int) {

            }
        })
    }

    //切换Fragment
    private fun switchFragment(position: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        when (position) {
            0 // 首页
            -> mHomeFragment?.let {
                transaction.show(it)
            }?: HomeFragment.getInstance(mTitles[position]).let {
                mHomeFragment = it
                transaction.add(R.id.fl_container, it, "home")
            }
            1 //我的
            -> mMineFragment?.let {
                transaction.show(it)
            }?: MineFragment.getInstance(mTitles[position]).let {
                mMineFragment = it
                transaction.add(R.id.fl_container, it, "mine") }

            else -> {

            }
        }
        transaction.commitAllowingStateLoss()
    }

    //隐藏所有的Fragment
    private fun hideFragments(transaction: androidx.fragment.app.FragmentTransaction) {
        mHomeFragment?.let { transaction.hide(it) }
        mMineFragment?.let { transaction.hide(it) }
    }

}