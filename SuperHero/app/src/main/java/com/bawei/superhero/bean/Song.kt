package com.bawei.superhero.bean

import java.io.Serializable

/**
 * 1. 存放歌曲的容器
 * 2. @author chensi
 * 3. @date 2017/10/3 12:04
 */

class Song : Serializable {
    lateinit var singer: String//歌手
    lateinit var song: String//歌曲名称
    lateinit var path: String//歌曲地址
    var duration: Int = 0//歌曲长度
    var size: Long = 0//歌曲的大小
    lateinit var album_id: String//根据这个查找图片
    lateinit var album: String//专辑图片
    var isplay: Boolean? = null
    lateinit var downUrl: String//歌曲下载地址

    constructor(downUrl: String, album: String, singer: String, song: String, path: String, duration: Int, size: Long, album_id: String, isplay: Boolean?) {
        this.downUrl = downUrl
        this.singer = singer
        this.song = song
        this.path = path
        this.duration = duration
        this.size = size
        this.album_id = album_id
        this.isplay = isplay
        this.album = album
    }

    constructor() {}


}
