package com.bawei.superhero.mvp.model

import android.content.Context
import com.bawei.superhero.api.Api
import com.bawei.superhero.bean.VideoBean
import com.bawei.superhero.inter.RetrofitService
import com.bawei.superhero.utils.RetrofitUtils
import io.reactivex.Flowable

/**
 * Created by 苏康泰 on 2017/11/27.
 */
class VideoModel :VideoModelInterface{
    override fun getVideoData(context: Context,isB:Boolean): Flowable<VideoBean.VideoBean> {
        val flowable = RetrofitUtils.getInstance(context)!!.create(RetrofitService::class.java, Api.VIDEO_URL)
        when(isB){
            true ->return flowable?.getVideo()!!//默认
            false ->return flowable?.getVideo()!!
        }
    }
}