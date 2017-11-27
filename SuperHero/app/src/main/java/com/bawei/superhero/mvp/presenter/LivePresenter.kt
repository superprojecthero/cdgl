package com.bawei.superhero.mvp.presenter

import com.bawei.superhero.LiveTab
import com.bawei.superhero.mvp.model.LiveModel
import com.bawei.superhero.mvp.view.LiveView

/**
 *  1. 类的用途
 * 2. @author chensi
 * 3. @date 2017/11/23 10:06
 */
class LivePresenter (val liveView: LiveView){
    //请求网络 调起model
    fun getLiveModel(){
        val liveModel = LiveModel()
        liveModel.getLiveData(this)
    }
    //回调view 将数据传到live的fragment
    fun getLiveView(liveTab: LiveTab.DataBean){
        liveView.getLive(liveTab)
    }
}