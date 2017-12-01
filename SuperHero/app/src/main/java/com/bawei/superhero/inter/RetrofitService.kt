package com.bawei.superhero.inter

import com.bawei.superhero.LiveTab
import com.bawei.superhero.bean.HttpSong
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *  1. 类的用途
 * 2. @author chensi
 * 3. @date 2017/11/23 09:59
 */
interface RetrofitService {
    /**
     * 直播页面 tablayout
     */
    @GET("api/v1/getColumnList?client_sys=android")
    fun getLiveData():Flowable<LiveTab.DataBean>
    /**
     * 查找网络音乐
     */
    @GET("213-1?showapi_appid= 47494&showapi_sign=94c8f5950ba64183abfaa31f1c4c0df7&page=1")
    fun getMusic(@Query("keyword")string: String):Flowable<HttpSong>
}