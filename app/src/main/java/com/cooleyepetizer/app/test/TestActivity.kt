package com.cooleyepetizer.app.test

import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ActivityPenBinding
import com.lpen.library.base.BaseActivity
import com.lpen.library.listener.OnViewModelClickListener
import com.lpen.library.widget.refresh.api.RefreshLayout
import com.lpen.library.widget.refresh.listener.OnRefreshLoadMoreListener
import kotlinx.android.synthetic.main.activity_pen.*


/**
 * @author android_p
 * @date 2019/8/22
 */
class TestActivity : BaseActivity<ActivityPenBinding, TestViewModel>(), OnViewModelClickListener<TestItemViewModel> {

    private var mAdapter: TestAdapter? = null
    private var mPageNum = 1

    override fun getLayoutRes() = R.layout.activity_pen

    override fun initViewModel(): TestViewModel {
        return ViewModelProviders.of(this)[TestViewModel::class.java]
    }

    override fun initView() {
        getViewModel()?.title?.set("测试一下")
        getViewModel()?.showBack?.set(false)

        recycler.layoutManager = LinearLayoutManager(this)
        mAdapter = TestAdapter()
        mAdapter!!.bindToRecyclerView(recycler)
        mAdapter!!.addOnItemClickListener(this)
//        mAdapter.emptyView = ?

        refresh?.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
            override fun onRefresh(refreshLayout: RefreshLayout) {
                mPageNum = 1
                Handler().postDelayed({
                    loadContent()
                }, 2000)
            }

            override fun onLoadMore(refreshLayout: RefreshLayout) {
                Handler().postDelayed({
                    loadContent()
                }, 1500)
            }
        })

        showLoading()
        Handler().postDelayed({
            loadContent()
        }, 3000)
    }

    private fun loadContent() {
        hideLoading()

        val list = ArrayList<TestItemViewModel>()
        for (index in 1..10) {
            val model = TestItemViewModel()
            model.avatar.set("http://p2.music.126.net/Mg3tcpPJ7yyhk72O2VHPVw==/6655343883472120.jpg?param=300x300")
            model.nickName.set("小辉辉 ${(mPageNum - 1) * 10 + index}")
            list.add(model)
        }

        if (mPageNum == 1) {
            mAdapter?.setNewData(list)
        } else {
            mAdapter?.addData(list)
        }
        mPageNum++

        refresh?.finishRefresh()
        if (mAdapter?.data?.size ?: 0 >= 50) {
            refresh?.finishLoadMoreWithNoMoreData()
        } else {
            refresh?.finishLoadMore()
            refresh?.resetNoMoreData()
        }
    }

    override fun onClick(v: View?, model: TestItemViewModel) {
        when (v?.id) {
            R.id.imgAvatar -> {
                Toast.makeText(this, "头像点击", Toast.LENGTH_SHORT).show()
            }
            R.id.imgMenu -> {
                Toast.makeText(this, "菜单点击", Toast.LENGTH_SHORT).show()
            }
        }
    }

}