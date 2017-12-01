package com.bawei.superhero.activity

import android.content.Context
import android.widget.ImageView

import com.bumptech.glide.Glide
import com.youth.banner.loader.ImageLoader

/**
 * 1:类的用途
 * 2：@author Dell
 * 3：@date 2017/9/4
 */

class BannerImageLoader : ImageLoader() {
    override fun displayImage(context: Context, path: Any, imageView: ImageView) {
        Glide.with(context).load(path).into(imageView)
    }
}
