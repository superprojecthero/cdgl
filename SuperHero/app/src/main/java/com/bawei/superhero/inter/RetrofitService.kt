package com.bawei.superhero.inter

import com.bawei.superhero.bean.LiveData
import com.bawei.superhero.bean.LiveTab
import com.bawei.superhero.bean.VideoBean
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

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

    /**
     * 直播页面主体数据
     * http://open.douyucdn.cn/api/RoomApi/live/lol
     */
    @GET("api/RoomApi/live/{game}")
    fun getLive(@Path("game")string: String):Flowable<LiveData.DataBean>
    @GET("v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    fun getVideo():Flowable<VideoBean.VideoBean>

}