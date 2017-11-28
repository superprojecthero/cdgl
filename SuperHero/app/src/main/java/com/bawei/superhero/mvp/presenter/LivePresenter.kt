package com.bawei.superhero.mvp.presenter

import android.content.Context
import com.bawei.superhero.bean.LiveData
import com.bawei.superhero.bean.LiveTab
import com.bawei.superhero.mvp.model.LiveModel
import com.bawei.superhero.mvp.view.LiveView

/**
 *  1. 类的用途
 * 2. @author chensi
 * 3. @date 2017/11/23 10:06
 */
class LivePresenter (){
    var liveModel : LiveModel? = null
    var liveView : LiveView? =null
    var ld : com.bawei.superhero.mvp.view.LiveData?=null

    constructor(liveView: LiveView,context: Context):this(){
        liveModel=LiveModel(context)
        this.liveView=liveView
    }
    //请求网络 调起model tablayout
    fun getLiveModel(){
        liveModel?.getLiveData(this)
    }
    //回调view 将数据传到live的fragment
    fun getLiveView(liveTab: LiveTab.DataBean){
        liveView?.getLive(liveTab)
    }

    constructor(ld: com.bawei.superhero.mvp.view.LiveData,context: Context): this(){
        liveModel = LiveModel(context)
        this.ld=ld
    }
    //请求网络 调起model 主体数据
    fun getLiveDataModel(string: String){
        liveModel?.getLive(this,string)
    }
    //回调view 将数据传到live的fragment(主体数据)
    fun getLiveData(liveData: LiveData.DataBean){
        ld?.getLiveData(liveData)
    }


}