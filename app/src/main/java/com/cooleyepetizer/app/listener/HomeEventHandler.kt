package com.cooleyepetizer.app.listener

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.activity.home.CategoryActivity
import com.cooleyepetizer.app.activity.home.RankActivity
import com.cooleyepetizer.app.activity.home.ThemeActivity
import com.cooleyepetizer.app.activity.home.VideoPlayActivity
import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.common_lib.config.Constant
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

class HomeEventHandler {

    fun jumpToCategoryAll(){
        val intent = Intent(BaseApplication.instance,CategoryActivity::class.java)
        BaseApplication.instance.startActivity(intent)
    }

    fun jumpToTextCardType(item: EyeListItemBean){
        when(item.data.text){
            "开眼专栏" ->{

            }
            "推荐主题" -> {
                val intent = Intent(BaseApplication.instance, ThemeActivity::class.java)
                BaseApplication.instance.startActivity(intent)
            }
            "本周榜单" ->{
                val intent = Intent(BaseApplication.instance, RankActivity::class.java)
                BaseApplication.instance.startActivity(intent)
            }
        }
    }

    fun jumpToVideoPlay(item: EyeListItemBean, view: View,activity: RxAppCompatActivity){
        //val activity: Activity = BaseApplication.instance as Activity
        val intent = Intent(activity, VideoPlayActivity::class.java)
        intent.putExtra(Constant.BUNDLE_VIDEO_DATA, item)
        intent.putExtra(VideoPlayActivity.TRANSITION, true)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            val pair = Pair(view, VideoPlayActivity.IMG_TRANSITION)
            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity, pair)
            ActivityCompat.startActivity(activity, intent, activityOptions.toBundle())
        } else {
            activity.startActivity(intent)
            activity.overridePendingTransition(R.anim.anim_in, R.anim.anim_out)
        }
    }

}