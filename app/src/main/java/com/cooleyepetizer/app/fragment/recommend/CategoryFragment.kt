package com.cooleyepetizer.app.fragment.recommend

import android.graphics.Rect
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.recommend.CategoryAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmFragment
import com.cooleyepetizer.app.databinding.FragmentCategoryBinding
import com.cooleyepetizer.app.utils.CommonUtils
import com.cooleyepetizer.app.viewmodel.recommend.CategoryViewModel
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : BaseMvvmFragment<FragmentCategoryBinding, CategoryViewModel>(){

    private val categoryAdapter by lazy { activity?.let { CategoryAdapter() } }

    override fun onBindLayout(): Int {
        return R.layout.fragment_category
    }

    override fun onBindViewModel(): Class<CategoryViewModel> {
        return CategoryViewModel::class.java
    }

    override fun initView() {
        isHideToolBar(true)

        category_list.adapter = categoryAdapter
        category_list.layoutManager = GridLayoutManager(activity,2)
        category_list.addItemDecoration(object : RecyclerView.ItemDecoration() {

            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                val position = parent.getChildPosition(view)
                val offset = CommonUtils().dp2px(1f)!!

                outRect.set(if (position % 2 == 0) 0 else offset, offset,
                    if (position % 2 == 0) offset else 0, offset)
            }

        })
    }

    override fun initData() {
        mViewModel?.getCategory()
        mViewModel?.categoryList?.observe(this, Observer {
            categoryAdapter?.setList(it)
        })
    }
}