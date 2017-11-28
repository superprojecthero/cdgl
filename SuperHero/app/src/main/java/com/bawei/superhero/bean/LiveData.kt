package com.bawei.superhero.bean

/**
 * 1. 类的用途
 * 2. @author chensi
 * 3. @date 2017/11/28 08:34
 */

class LiveData{

data class DataBean(
		val error: Int, //0
		val data: List<Data>
)

data class Data(
		val room_id: String, //526408
		val room_src: String, //https://rpic.douyucdn.cn/alrpic/171128/526408_0822.jpg
		val vertical_src: String, //https://rpic.douyucdn.cn/alrpic/171128/526408_0822.jpg
		val isVertical: Int, //0
		val cate_id: Int, //1
		val room_name: String, //王者AD 吹就完了
		val owner_uid: String, //34533504
		val nickname: String, //良人与猫zzz
		val online: Int, //15445
		val url: String, //http://www.douyu.com/526408
		val game_url: String, //http://www.douyu.com/directory/game/LOL
		val game_name: String, //英雄联盟
		val avatar: String, //https://apic.douyucdn.cn/upload/avanew/face/201707/19/22/3a4ca183080ceba612ac2f8bd15cfa6e_big.jpg
		val avatar_mid: String, //https://apic.douyucdn.cn/upload/avanew/face/201707/19/22/3a4ca183080ceba612ac2f8bd15cfa6e_middle.jpg
		val avatar_small: String, //https://apic.douyucdn.cn/upload/avanew/face/201707/19/22/3a4ca183080ceba612ac2f8bd15cfa6e_small.jpg
		val jumpUrl: String,
		val icon_data: IconData
)

data class IconData(
		val status: Int, //4
		val icon_url: String, //https://staticlive.douyucdn.cn/upload/icon/74daf2afda59c97fa3a2d69f04caa90d.jpg
		val icon_width: String, //126
		val icon_height: String //33
)
}
