package com.bawei.superhero.inter

<<<<<<< HEAD
import com.bawei.superhero.bean.LiveData
import com.bawei.superhero.bean.LiveTab
=======
import com.bawei.superhero.LiveTab
<<<<<<< HEAD
import com.bawei.superhero.bean.HttpSong
=======
>>>>>>> b78d1fd2d756ddf10daf956980fa453938b24e93
import com.bawei.superhero.bean.VideoBean
>>>>>>> 2b37b975307c003ab057d96dd8091b0a38c77769
import io.reactivex.Flowable
import retrofit2.http.GET
<<<<<<< HEAD
import retrofit2.http.Path
=======
import retrofit2.http.Query
>>>>>>> b78d1fd2d756ddf10daf956980fa453938b24e93

/**
 *  1. 类的用途
 * 2. @author chensi
 * 3. @date 2017/11/23 09:5900
 */
interface RetrofitService {
    /**
     * 直播页面 tablayout
     * http://open.douyucdn.cn/api/RoomApi/game
     */
    @GET("api/RoomApi/game")
    fun getLiveData():Flowable<LiveTab.DataBean>
<<<<<<< HEAD
    /**
     * 查找网络音乐
     */
    @GET("213-1?showapi_appid= 47494&showapi_sign=94c8f5950ba64183abfaa31f1c4c0df7&page=1")
    fun getMusic(@Query("keyword")string: String):Flowable<HttpSong>
=======

    /**
     * 直播页面主体数据
     * http://open.douyucdn.cn/api/RoomApi/live/lol
     */
    @GET("api/RoomApi/live/{game}")
    fun getLive(@Path("game")string: String):Flowable<LiveData.DataBean>
    @GET("v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    fun getVideo():Flowable<VideoBean.VideoBean>

>>>>>>> 2b37b975307c003ab057d96dd8091b0a38c77769
}