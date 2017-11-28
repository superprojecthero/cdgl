package com.bawei.superhero.fragment

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.view.animation.Animation
import android.widget.ImageView
import com.bawei.superhero.bean.LiveTab
import com.bawei.superhero.R
import com.bawei.superhero.bean.LiveData
import com.bawei.superhero.mvp.presenter.LivePresenter
import com.bawei.superhero.mvp.view.LiveView
import com.gyf.barlibrary.ImmersionBar
import kotlinx.android.synthetic.main.livefragment.*

/**
 * Created by la on 2017/11/23.
 */
class LiveFragment : Fragment(),LiveView{
    var tab:TabLayout?=null
    var vp:ViewPager?=null
    var ani:ImageView?=null
    var drawable : AnimationDrawable?=null
    //请求直播页面的tablayout
    override fun getLive(liveTab: LiveTab.DataBean) {
        liveTab.data.forEach {
           tab?.addTab(tab?.newTab()!!.setText(it.game_name))
        }
        vp?.adapter=MyAdapter(childFragmentManager,liveTab)
        tab?.setupWithViewPager(vp)
        drawable?.stop()
        ani?.visibility=View.GONE
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater?.inflate(R.layout.livefragment, container, false)
        ImmersionBar.with(activity).init();
        tab = inflate?.findViewById(R.id.tab) as TabLayout
        vp = inflate?.findViewById(R.id.vp) as ViewPager
        ani=inflate?.findViewById(R.id.ani) as ImageView
        tab?.tabMode=TabLayout.MODE_SCROLLABLE

        return inflate
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ani?.setImageResource(R.drawable.refresh)
        drawable = ani?.drawable as AnimationDrawable
        drawable?.start()
        val livePresenter = LivePresenter(this,activity)
        livePresenter.getLiveModel()
    }
    internal class MyAdapter(fragmentManager: FragmentManager,var liveTab: LiveTab.DataBean) : FragmentPagerAdapter(fragmentManager) {
        override fun getItem(position: Int): Fragment {
            return LiveDataFragment.newInstance(liveTab.data.get(position).short_name)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return liveTab.data.get(position).game_name
        }

        override fun getCount(): Int {
            return liveTab.data.size
        }

    }
}