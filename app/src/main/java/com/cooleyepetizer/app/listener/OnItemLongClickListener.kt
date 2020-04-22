package com.cooleyepetizer.app.listener

interface OnItemLongClickListener<T> {

    fun onLongClick(t: T, position: Int)
}