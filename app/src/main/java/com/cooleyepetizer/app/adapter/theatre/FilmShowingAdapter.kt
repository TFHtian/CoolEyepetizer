package com.cooleyepetizer.app.adapter.theatre

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ItemFilmShowingBinding
import com.cooleyepetizer.app.entity.film.ShowingM

class FilmShowingAdapter : BaseQuickAdapter<ShowingM,BaseDataBindingHolder<ItemFilmShowingBinding>>(
    R.layout.item_film_showing){

    override fun convert(holder: BaseDataBindingHolder<ItemFilmShowingBinding>, item: ShowingM) {
        val binding: ItemFilmShowingBinding? = holder.dataBinding
        if (binding != null) {
            binding.bean = item
            binding.executePendingBindings()
        }
    }
}