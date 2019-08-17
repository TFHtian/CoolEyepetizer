package com.cooleyepetizer.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.cooleyepetizer.app.viewmodel.PlaceViewModel

class Test2Activity : AppCompatActivity() {

    private var viewModel : PlaceViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)

        viewModel = ViewModelProviders.of(this)[PlaceViewModel::class.java]

        viewModel?.getPlace(this)
    }
}
