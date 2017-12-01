package com.bawei.superhero.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.bawei.superhero.R
import com.bawei.superhero.activity.FindActivity
import com.bawei.superhero.activity.LocalSongActivity

/**
 * Created by la on 2017/11/23.
 */
class MusicFragment : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        Log.e("SSSS","跳转")
        startActivity(Intent(activity, LocalSongActivity::class.java))
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater?.inflate(R.layout.main_view, container, false)

        var song_local = inflate?.findViewById(R.id.song_local) as LinearLayout
        var btn_search = inflate?.findViewById(R.id.btn_search) as ImageView

        song_local.setOnClickListener(this)
        btn_search.setOnClickListener(View.OnClickListener {
            startActivity(Intent(activity,FindActivity::class.java))
        })
        return inflate

    }
}