package com.bawei.superhero.inter

import com.bawei.superhero.bean.LiveData
import com.bawei.superhero.bean.LiveTab
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *  1. 类的用途
 * 2. @author chensi
 * 3. @date 2017/11/23 09:59
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
}