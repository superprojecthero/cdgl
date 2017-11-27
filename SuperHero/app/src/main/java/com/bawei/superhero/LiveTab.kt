package com.bawei.superhero

/**
 *  1. 类的用途
 * 2. @author chensi
 * 3. @date 2017/11/23 18:41
 */
class LiveTab {

data class DataBean(
		val error: Int, //0
		val data: List<Data>
)

data class Data(
		val cate_id: String, //1
		val cate_name: String, //热门游戏
		val short_name: String, //game
		val push_ios: String, //1
		val push_show: String, //0
		val push_vertical_screen: String, //0
		val push_nearby: String //0
)
}