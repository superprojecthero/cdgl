package com.bawei.superhero.mvp.model

import android.content.Context
import com.bawei.superhero.api.Api
import com.bawei.superhero.bean.HomeBean
import com.bawei.superhero.inter.RetrofitService
import com.bawei.superhero.utils.RetrofitUtils
import io.reactivex.Flowable

/**
 * Created by Administrator on 2017/12/1 0001.
 */

class HomeM : HomeModel {
    override fun getVideoData(context: Context):Flowable<HomeBean> {
        val bb = RetrofitUtils.getInstance(context)!!.create(RetrofitService::class.java, Api.VIDEO_URL1)
        var home= bb!!.getHome()
        return home
    }

}

