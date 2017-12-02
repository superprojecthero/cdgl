package com.bawei.superhero.mvp.view

import com.bawei.superhero.bean.LiveData
import com.bawei.superhero.bean.LiveTab

/**
 *  1. 类的用途
 * 2. @author chensi
 * 3. @date 2017/11/23 10:06
 */
interface LiveView {
    //回传数据 头部tablayout
    fun getLive(liveTab: LiveTab.DataBean)

}