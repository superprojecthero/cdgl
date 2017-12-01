package com.bawei.superhero.bean

/**
 * 1. 类的用途
 * 2. @author chensi
 * 3. @date 2017/10/10 20:16
 */

class LrcContent {

    var lrcStr: String? = null//歌词文本
    var lrcTime: Int = 0//歌词当前时间

    constructor(lrcStr: String, lrcTime: Int) {
        this.lrcStr = lrcStr
        this.lrcTime = lrcTime
    }

    constructor() {}
}
