package com.bawei.superhero.fragment

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.bawei.superhero.MyService
import com.bawei.superhero.R
import com.bawei.superhero.activity.FindActivity
import com.bawei.superhero.activity.LocalSongActivity

/**
 * Created by la on 2017/11/23.
 */
class MusicFragment : Fragment(), View.OnClickListener {
    companion object {
        var mBinder: MyService.MyBinder? = null
    }
    var connection: ServiceConnection? = null
    var serviceIntent: Intent? = null

    override fun onClick(v: View?) {
        Log.e("SSSS","跳转")
        startActivity(Intent(activity, LocalSongActivity::class.java))
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater?.inflate(R.layout.main_view, container, false)

        var song_local = inflate?.findViewById(R.id.song_local) as LinearLayout
        var btn_search = inflate?.findViewById(R.id.btn_search) as ImageView

        //开启服务
        StartService()

        song_local.setOnClickListener(this)
        btn_search.setOnClickListener(View.OnClickListener {
            startActivity(Intent(activity,FindActivity::class.java))
        })
        return inflate

    }

    private fun StartService() {
        serviceIntent = Intent(activity, MyService::class.java)
        connection = object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName, service: IBinder) {
                mBinder = service as MyService.MyBinder
            }

            override fun onServiceDisconnected(name: ComponentName) {

            }
        }
        // 绑定service--->让我们的本activity和service生命周期进行绑定
        activity.bindService(serviceIntent, connection, Context.BIND_AUTO_CREATE)
    }
}