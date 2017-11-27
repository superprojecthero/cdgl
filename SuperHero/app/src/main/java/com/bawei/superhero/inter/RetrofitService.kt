package com.bawei.superhero.inter

import com.bawei.superhero.LiveTab
import io.reactivex.Flowable
import retrofit2.http.GET

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
}