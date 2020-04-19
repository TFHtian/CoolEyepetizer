package com.cooleyepetizer.app.activity.start

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.activity.main.MainActivity

class SplashActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed(Runnable {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.screen_zoom_in, R.anim.screen_zoom_out)
            finish()
        },1000)
    }
}