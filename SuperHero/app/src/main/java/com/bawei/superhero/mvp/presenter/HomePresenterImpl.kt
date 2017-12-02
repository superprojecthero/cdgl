package com.bawei.superhero.mvp.presenter

import android.content.Context
import android.util.Log
import com.bawei.superhero.bean.HomeBean
import com.bawei.superhero.mvp.model.HomeM
import com.bawei.superhero.mvp.view.HomeView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Administrator on 2017/12/1 0001.
 */
class HomePresenterImpl:HomePresenter {
    var homeView:HomeView?=null
    var homeModel:HomeM?=null
    constructor(homeView: HomeView?) {
        this.homeView = homeView
        homeModel= HomeM()
    }

    override fun getHomeBean(context: Context) {
        var videoData = homeModel?.getVideoData(context)
        videoData?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe {
                    bean:HomeBean->
                    Log.e("sss1",bean.toString())
                    homeView?.setHome(bean)
                }
    }
}