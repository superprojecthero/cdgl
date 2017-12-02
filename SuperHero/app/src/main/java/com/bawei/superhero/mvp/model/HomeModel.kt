package com.bawei.superhero.mvp.model

import android.content.Context
import com.bawei.superhero.bean.HomeBean
import io.reactivex.Flowable

/**
 * Created by Administrator on 2017/12/1 0001.
 */

interface HomeModel{
    fun getVideoData( context: Context) : Flowable<HomeBean>
}
