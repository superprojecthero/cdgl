package com.bawei.superhero.bean

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
		val cate_id: String, //181
		val game_name: String, //王者荣耀
		val short_name: String, //wzry
		val game_url: String, //http://www.douyu.com/directory/game/wzry
		val game_src: String, //https://staticlive.douyucdn.cn/upload/game_cate/b14b8890330ca7cb5185b954808485fc.jpg
		val game_icon: String //https://staticlive.douyucdn.cn/upload/game_cate/f719087663581b7a723c4d39f8721bc1.jpg
)
}