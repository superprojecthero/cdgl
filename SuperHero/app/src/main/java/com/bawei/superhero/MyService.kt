package com.bawei.superhero

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder

/**
 * Created by la on 2017/11/30
 */
class MyService : Service() {

    override fun onBind(intent: Intent?): IBinder {
        media = MediaPlayer()

        return MyBinder()
    }

    class MyBinder : Binder() {
        fun musicplay(str : String){
            getPlay(str)
        }

    }
        companion object {
            var media : MediaPlayer ?= null
             fun getPlay(str: String) {
                 media?.reset()
                 media?.setDataSource(str)
                 media?.prepare()
                 media?.start()
            }
        }
}