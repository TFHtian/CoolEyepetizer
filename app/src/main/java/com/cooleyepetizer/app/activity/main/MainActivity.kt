package com.cooleyepetizer.app.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cooleyepetizer.app.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_content.text = "hfhksdf"
    }
}
