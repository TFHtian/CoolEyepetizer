package com.cooleyepetizer.app.entity.eye_video

data class EyeItemDataBean (
    val actionUrl: String,
    val ad: Boolean,
    val adTrack: Any,
    val author: EyeAuthorBean,
    val autoPlay: Boolean,
    val brandWebsiteInfo: Any,
    val campaign: Any,
    val category: String,
    val backgroundImage: String,
    val bgPicture: String,
    val collected: Boolean,
    val consumption: EyeConsumptionBean,
    val count: Int,
    val owner: EyeItemOwnerBean,
    val cover: EyeCoverBean,
    val dataType: String,
    val date: Long,
    val description: String,
    val descriptionEditor: String,
    val descriptionPgc: String,
    val duration: Long,
    val expert: Boolean,
    val favoriteAdTrack: Any,
    val follow: Any,
    val footer: Any,
    val haveReward: Boolean,
    val header: EyeHeaderBean,
    val content: EyeItemContentBean,
    val icon: String,
    val iconType: String,
    val id: Int,
    val idx: Int,
    val ifLimitVideo: Boolean,
    val ifNewest: Boolean,
    val ifPgc: Boolean,
    val ifShowNotificationIcon: Boolean,
    val image: String,
    val itemList: List<EyeListItemBean>,
    val titleList: List<String>,
    val label: Any,
    val labelList: Any,
    val lastViewTime: Any,
    val library: String,
    val medalIcon: Boolean,
    val newestEndTime: Any,
    val playInfo: List<EyePlayInfoBean>,
    val playUrl: String,
    val played: Boolean,
    val playlists: Any,
    val promotion: Any,
    val provider: EyeProviderBean,
    val reallyCollected: Boolean,
    val recallSource: Any,
    val releaseTime: Long,
    val remark: String,
    val resourceType: String,
    val rightText: String,
    val searchWeight: Int,
    val shade: Boolean,
    val shareAdTrack: Any,
    val slogan: Any,
    val src: Any,
    val subTitle: Any,
    val subtitles: List<Any>,
    val switchStatus: Boolean,
    val tags: List<EyeTagBean>,
    val text: String,
    val thumbPlayUrl: Any,
    val title: String,
    val titlePgc: String,
    val type: String,
    val uid: Int,
    val waterMarks: Any,
    val webAdTrack: Any,
    val webUrl: EyeWebUrlBean,
    val width: Int,
    val height: Int
){
    fun getInformationContent(): String{
        var content = ""
        for (str in titleList){
            content = str + "\n"
        }
        return content
    }

    fun getBriefShowFollow(): Boolean{
        return when (dataType) {
            "TagBriefCard" -> true
            "TopicBriefCard" -> false
            else -> true
        }
    }

}
