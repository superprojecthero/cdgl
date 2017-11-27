package com.bawei.superhero.mvp.view

import com.bawei.superhero.LiveTab

/**
 *  1. 类的用途
 * 2. @author chensi
 * 3. @date 2017/11/23 10:06
 */
interface LiveView {
    //回传数据
    fun getLive(liveTab: LiveTab.DataBean)
}