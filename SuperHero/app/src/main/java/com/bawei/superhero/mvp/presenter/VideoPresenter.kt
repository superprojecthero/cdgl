package com.bawei.superhero.mvp.presenter

import android.content.Context
import android.util.Log

import com.bawei.superhero.bean.VideoBean
import com.bawei.superhero.mvp.model.VideoModel
import com.bawei.superhero.mvp.model.VideoModelInterface
import com.bawei.superhero.mvp.view.VideoView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by 苏康泰 on 2017/11/27.
 */
class VideoPresenter(video: VideoView):VideoPresenterInterface{

     var videov:VideoView
     var videoModel: VideoModelInterface

    init {
        videov=video
        videoModel=VideoModel()

    }

    override fun getVideoData(context: Context) {

        val videoData = videoModel.getVideoData(context, true)
        videoData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{bean: VideoBean.VideoBean->
                    videov.setVideo(bean)
                    Log.e("xxx1",bean.toString())
                }

    }
}