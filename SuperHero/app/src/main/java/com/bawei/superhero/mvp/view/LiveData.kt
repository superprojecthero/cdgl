package com.bawei.superhero.mvp.view

import com.bawei.superhero.bean.LiveData

/**
 *  1. 类的用途
 * 2. @author chensi
 * 3. @date 2017/11/28 09:11
 */
interface LiveData {
    //回传数据 主体数据
    fun getLiveData(liveData: LiveData.DataBean)
}