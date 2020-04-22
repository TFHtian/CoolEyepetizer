package com.cooleyepetizer.app.listener

interface OnItemClickListener<T> {

    fun onClick(t: T, position: Int)
}