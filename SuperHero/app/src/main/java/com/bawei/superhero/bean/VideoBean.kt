package com.bawei.superhero.bean

import java.io.Serializable

/**
 * Created by 苏康泰 on 2017/11/27.
 */
class VideoBean :Serializable{

data class VideoBean(
		val issueList: List<Issue>,
		val nextPageUrl: String, //http://baobab.kaiyanapp.com/api/v2/feed?date=1511571600000&num=2
		val nextPublishTime: Long, //1511830800000
		val newestIssueType: String, //morning
		val dialog: Any //null
)

data class Issue(
		val releaseTime: Long, //1511744400000
		val type: String, //morning
		val date: Long, //1511744400000
		val publishTime: Long, //1511744400000
		val itemList: List<Item>,
		val count: Int //8
)

data class Item(
		val type: String, //banner2
		val data: Data,
		val tag: Any, //null
		val id: Int //0
)

data class Data(
		val dataType: String, //Banner
		val id: Int, //0
		val title: String,
		val description: String,
		val image: String, //http://img.kaiyanapp.com/eef24aa10ab6cf17b5a512943ec22053.jpeg?imageMogr2/quality/60/format/jpg
		val actionUrl: String,
		val adTrack: Any, //null
		val shade: Boolean, //false
		val label: Any, //null
		val labelList: Any, //null
		val header: Any ,//null
		val playUrl:String,
        val cover:Cover
)
	data class Cover(
			val feed:String
	)
}