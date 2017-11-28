package com.bawei.superhero.inter

import com.bawei.superhero.LiveTab
import com.bawei.superhero.bean.VideoBean
import io.reactivex.Flowable
import retrofit2.http.GET

/**
 *  1. 类的用途
 * 2. @author chensi
 * 3. @date 2017/11/23 09:5900
 */
interface RetrofitService {
    /**
     * 直播页面 tablayout
     */
    @GET("api/v1/getColumnList?client_sys=android")
    fun getLiveData():Flowable<LiveTab.DataBean>

    @GET("v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    fun getVideo():Flowable<VideoBean.VideoBean>

}