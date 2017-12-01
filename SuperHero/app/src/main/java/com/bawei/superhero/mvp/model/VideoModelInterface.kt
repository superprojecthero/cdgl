package com.bawei.superhero.mvp.model

import android.content.Context
import com.bawei.superhero.bean.VideoBean
import io.reactivex.Flowable

/**
 * Created by 苏康泰 on 2017/11/27.
 */
interface VideoModelInterface {
    fun getVideoData(context:Context,isB:Boolean):Flowable<VideoBean.VideoBean>
}