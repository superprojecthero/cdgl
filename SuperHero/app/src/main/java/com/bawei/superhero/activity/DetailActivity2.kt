package com.bawei.superhero.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.bawei.superhero.R
import com.bawei.superhero.bean.Song
import com.bawei.superhero.fragment.MusicFragment.Companion.mBinder

class DetailActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail2)

        var back = findViewById(R.id.back) as ImageView
        var song_name = findViewById(R.id.song_name) as TextView

        val intent = intent.getSerializableExtra("songs") as Song
        mBinder?.musicplay(intent.path)

    }
}
