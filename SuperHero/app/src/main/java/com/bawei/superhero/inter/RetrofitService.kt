package com.bawei.superhero.inter

<<<<<<< HEAD
import com.bawei.superhero.bean.*
=======
import com.bawei.superhero.bean.HttpSong
import com.bawei.superhero.bean.LiveData
import com.bawei.superhero.bean.LiveTab
import com.bawei.superhero.bean.VideoBean
>>>>>>> 965a0fd94bf842b62a68a792eded18ed86c382f8
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

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
<<<<<<< HEAD
    fun getLiveData(): Flowable<LiveTab.DataBean>
=======
    fun getLiveData():Flowable<LiveTab.DataBean>
>>>>>>> 965a0fd94bf842b62a68a792eded18ed86c382f8
    /**
     * 查找网络音乐
     */
    @GET("213-1?showapi_appid= 47494&showapi_sign=94c8f5950ba64183abfaa31f1c4c0df7&page=1")
    fun getMusic(@Query("keyword")string: String):Flowable<HttpSong>

    /**
     * 直播页面主体数据
     * http://open.douyucdn.cn/api/RoomApi/live/lol
     */
    @GET("api/RoomApi/live/{game}")
    fun getLive(@Path("game")string: String):Flowable<LiveData.DataBean>

    @GET("v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    fun getVideo():Flowable<VideoBean.VideoBean>
<<<<<<< HEAD
    //得到Homepage的视频数据
    @GET("255-1?showapi_appid=%2047494&showapi_sign=94c8f5950ba64183abfaa31f1c4c0df7&page=1&type=41")
    fun getHome():Flowable<HomeBean>
=======

>>>>>>> 965a0fd94bf842b62a68a792eded18ed86c382f8
}