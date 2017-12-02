package com.bawei.superhero.mvp.model

import android.content.Context
import com.bawei.superhero.bean.LiveData
import com.bawei.superhero.bean.LiveTab
import com.bawei.superhero.inter.RetrofitService
import com.bawei.superhero.mvp.presenter.LivePresenter
import com.bawei.superhero.utils.RetrofitUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *  1. 类的用途
 * 2. @author chensi
 * 3. @date 2017/11/23 10:06
 */
class LiveModel (var context: Context){
    fun getLiveData(livePresenter: LivePresenter){
        val retrofit = RetrofitUtils.getInstance(context)
        val service = retrofit?.create(RetrofitService::class.java,"http://open.douyucdn.cn")
        val liveData = service?.getLiveData()
        //请求直播页面的tablayout
        liveData?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { myBean: LiveTab.DataBean ->
                     livePresenter.getLiveView(myBean)
                }

    }
    //直播页面的主体数据
    fun getLive(livePresenter: LivePresenter,string: String){
        val retrofit = RetrofitUtils.getInstance(context)
        val service = retrofit?.create(RetrofitService::class.java,"http://open.douyucdn.cn")
        val liveData = service?.getLive(string)
        //请求直播页面的tablayout
        liveData?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { myBean: LiveData.DataBean ->
                    livePresenter.getLiveData(myBean)
                }
    }

}