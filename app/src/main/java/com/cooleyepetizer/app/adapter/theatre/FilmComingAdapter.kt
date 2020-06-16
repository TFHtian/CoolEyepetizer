package com.cooleyepetizer.app.adapter.theatre

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ItemFilmComingBinding
import com.cooleyepetizer.app.entity.film.MoviecomingBean

class FilmComingAdapter : BaseQuickAdapter<MoviecomingBean,BaseDataBindingHolder<ItemFilmComingBinding>>(
    R.layout.item_film_coming){
    override fun convert(
        holder: BaseDataBindingHolder<ItemFilmComingBinding>,
        item: MoviecomingBean
    ) {
        val binding: ItemFilmComingBinding? = holder.dataBinding
        if (binding != null) {
            binding.bean = item
            binding.executePendingBindings()
        }
    }
}