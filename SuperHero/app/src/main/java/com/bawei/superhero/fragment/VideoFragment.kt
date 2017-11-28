package com.bawei.superhero.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bawei.superhero.R
import com.bawei.superhero.adapter.VideoAdapter
import com.bawei.superhero.bean.VideoBean
import com.bawei.superhero.mvp.presenter.VideoPresenter
import com.bawei.superhero.mvp.view.VideoView

/**
 * Created by la on 2017/11/23.
 */
class VideoFragment : Fragment(), VideoView {
    var videoadapter:VideoAdapter?=null
    //val array=ArrayList<VideoBean.VideoBean>()
    var recycler: RecyclerView? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.videofragment, container, false)
        recycler = view!!.findViewById(R.id.recycler) as RecyclerView?
        var videopresenter=VideoPresenter(this)
        videopresenter.getVideoData(activity)
        return view
    }
    override fun setVideo(bean: VideoBean.VideoBean) {
        Log.e("xxx",bean.toString())
       // array.add(bean)
        videoadapter= VideoAdapter(activity,bean)

        recycler!!.layoutManager=LinearLayoutManager(activity)
        recycler!!.adapter=videoadapter

    }

}