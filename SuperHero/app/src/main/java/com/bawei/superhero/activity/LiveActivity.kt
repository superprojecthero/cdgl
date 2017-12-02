package com.bawei.superhero.activity

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import cn.jzvd.JZVideoPlayer

import com.bawei.superhero.R
import kotlinx.android.synthetic.main.activity_live.*
import android.support.v4.media.session.MediaControllerCompat.setMediaController
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import android.widget.MediaController


class LiveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live)
        val s = intent.getStringExtra("url")
        val settings = vv.settings
        settings.javaScriptCanOpenWindowsAutomatically=true
        settings.javaScriptEnabled=true
        vv.setWebChromeClient(WebChromeClient())
        vv.setWebViewClient(WebViewClient())
        vv.loadUrl(s)
    }
}
