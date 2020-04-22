package com.cooleyepetizer.app.entity.place

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class User(n: String, s: String,u: String): BaseObservable() {
    var name: String = n
        @Bindable get
    var sex: String = s
        @Bindable get
    var url: String = u
        @Bindable get
}