package com.bawei.superhero.inter

import android.media.MediaPlayer

/**
 * 1. 在detailactivity中接受media 接口回调实现自动播放下一首
 * 2. @author chensi
 * 3. @date 2017/10/5 09:35
 */

interface IGetMusic {
    fun IGetMusicPlayer(mediaPlayer: MediaPlayer)
}
