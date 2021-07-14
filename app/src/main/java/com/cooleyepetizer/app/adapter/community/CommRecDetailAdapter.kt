package com.cooleyepetizer.app.adapter.community

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.databinding.ItemCommRecDetailBinding
import com.cooleyepetizer.app.entity.eye_video.EyeListItemBean
import com.cooleyepetizer.app.extension.invisibleAlphaAnimation
import com.cooleyepetizer.app.extension.visibleAlphaAnimation
import com.cooleyepetizer.app.glide.GlideUtils
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack

class CommRecDetailAdapter(private var mContext: Context) : BaseQuickAdapter<EyeListItemBean, BaseDataBindingHolder<ItemCommRecDetailBinding>>(
    R.layout.item_comm_rec_detail) {

    override fun convert(holder: BaseDataBindingHolder<ItemCommRecDetailBinding>, item: EyeListItemBean) {
        holder.dataBinding?.run {
            videoPlayer.visibility = View.GONE
            viewPagerPhotos.visibility = View.GONE
            flHeader.visibility = View.VISIBLE
            llUgcInfo.visibility = View.VISIBLE
            ivPullDown.setOnClickListener { (mContext as Activity).finish() }
            GlideUtils.loadImage(mContext,ivAvatar,item.data.content.data.owner.avatar,0)
            tvNickName.text = item.data.content.data.owner.nickname
            tvDescription.text = item.data.content.data.description
            if (item.data.content.data.description.isBlank()) tvDescription.visibility = View.GONE else tvDescription.visibility = View.VISIBLE
            tvTagName.text = item.data.content.data.tags?.first()?.name
            if (item.data.content.data.tags.isNullOrEmpty()) tvTagName.visibility = View.GONE else tvTagName.visibility = View.VISIBLE
            tvCollectionCount.text = item.data.content.data.consumption.collectionCount.toString()
            tvReplyCount.text = item.data.content.data.consumption.replyCount.toString()
            holder.itemView.setOnClickListener {
                if (ivPullDown.visibility == View.VISIBLE) {
                    ivPullDown.invisibleAlphaAnimation()
                    llUgcInfo.invisibleAlphaAnimation()
                } else {
                    ivPullDown.visibleAlphaAnimation()
                    llUgcInfo.visibleAlphaAnimation()
                }
            }

            //区分视频与图片
            when (item.data.content.type) {
                STR_VIDEO_TYPE -> {
                    videoPlayer.visibility = View.VISIBLE
                    videoPlayer.run {
                        val data = item.data.content.data
                        val cover = ImageView(mContext)
                        cover.scaleType = ImageView.ScaleType.CENTER_CROP
                        GlideUtils.loadImage(mContext,cover,data.cover.detail,0)
                        cover.parent?.run { removeView(cover) }
                        thumbImageView = cover
                        setThumbPlay(true)
                        setIsTouchWiget(false)
                        isLooping = true
                        playPosition = holder.adapterPosition
                        setVideoAllCallBack(object : GSYSampleCallBack() {
                            override fun onClickBlank(url: String?, vararg objects: Any?) {
                                super.onClickBlank(url, *objects)
                                if (ivPullDown.visibility == View.VISIBLE) {
                                    ivPullDown.invisibleAlphaAnimation()
                                    llUgcInfo.invisibleAlphaAnimation()
                                } else {
                                    ivPullDown.visibleAlphaAnimation()
                                    llUgcInfo.visibleAlphaAnimation()
                                }
                            }
                        })
                        setUp(data.playUrl, false, null)
                    }
                }
                STR_UGC_PICTURE_TYPE -> {
                    viewPagerPhotos.visibility = View.VISIBLE
                    item.data.content.data.urls?.run {
                        viewPagerPhotos.orientation = ViewPager2.ORIENTATION_HORIZONTAL
                        viewPagerPhotos.offscreenPageLimit = 1
                        val photosAdapter = PhotosAdapter(mContext)
                        viewPagerPhotos.adapter = photosAdapter
                        photosAdapter.setList(item.data.content.data.urls)
                        if (item.data.content.data.urls.size > 1) {
                            tvPhotoCount.visibility = View.VISIBLE
                            tvPhotoCount.text = String.format(mContext.resources.getString(R.string.photo_count), 1, item.data.content.data.urls.size)
                        } else {
                            tvPhotoCount.visibility = View.GONE
                        }
                        viewPagerPhotos.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                            override fun onPageSelected(position: Int) {
                                super.onPageSelected(position)
                                tvPhotoCount.text = String.format(mContext.resources.getString(R.string.photo_count), position + 1, item.data.content.data.urls.size)
                            }
                        })
                    }
                }
                else -> {

                }
            }

        }

    }

    companion object {
        const val STR_VIDEO_TYPE = "video"
        const val STR_UGC_PICTURE_TYPE = "ugcPicture"
    }

}