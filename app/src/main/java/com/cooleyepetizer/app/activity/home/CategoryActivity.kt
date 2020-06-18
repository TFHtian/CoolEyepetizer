package com.cooleyepetizer.app.activity.home

import android.graphics.Rect
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.recommend.CategoryAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmActivity
import com.cooleyepetizer.app.databinding.ActivityCategoryBinding
import com.cooleyepetizer.app.utils.CommonUtils
import com.cooleyepetizer.app.viewmodel.home.CategoryViewModel
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : BaseMvvmActivity<ActivityCategoryBinding,CategoryViewModel>(){

    private val categoryAdapter by lazy { CategoryAdapter()  }

    override fun onBindViewModel(): Class<CategoryViewModel> {
       return CategoryViewModel::class.java
    }

    override fun onBindLayout(): Int {
        return R.layout.activity_category
    }

    override fun initView() {
        setCenterTitle(this.resources.getString(R.string.category_all))
        category_list.adapter = categoryAdapter
        category_list.layoutManager = GridLayoutManager(this,2)
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
        mViewModel?.getCategoryList()
        mViewModel?.categoryList?.observe(this, Observer {
            categoryAdapter?.setList(it)
        })
    }
}