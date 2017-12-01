package com.bawei.superhero.bean

import java.io.Serializable

/**
 * 1. 类的用途
 * 2. @author chensi
 * 3. @date 2017/10/16 12:05
 */

class VideoInfo : Serializable {
    var id: Int = 0
    var title: String? = null
    var album: String? = null
    var artist: String? = null
    var displayName: String? = null
    var mimeType: String? = null
    var path: String? = null
    var size: Long = 0
    var duration: Long = 0


    constructor() {}

    constructor(id: Int, title: String, album: String, artist: String, displayName: String, mimeType: String,
                path: String, size: Long, duration: Long) : super() {
        this.id = id
        this.title = title
        this.album = album
        this.artist = artist
        this.displayName = displayName
        this.mimeType = mimeType
        this.path = path
        this.size = size
        this.duration = duration
    }
}
