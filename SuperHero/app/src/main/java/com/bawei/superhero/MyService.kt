package com.bawei.superhero

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

/**
 * Created by la on 2017/11/30
 */
class MyService : Service() {

    override fun onBind(intent: Intent?): IBinder {
        return MyBinder()
    }
    internal class MyBinder : Binder() {

    }
}