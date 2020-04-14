package com.cooleyepetizer.app.entity.place

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class User(n: String, s: String): BaseObservable() {
    var name: String = n
        @Bindable get
    var sex: String = s
        @Bindable get
}