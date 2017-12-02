package com.bawei.superhero.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bawei.superhero.R
import com.bawei.superhero.bean.LiveTab
import com.bawei.superhero.mvp.presenter.LivePresenter
import com.bawei.superhero.mvp.view.LiveView
import com.gyf.barlibrary.ImmersionBar
import kotlinx.android.synthetic.main.homefragment.*

/**
 * Created by la on 2017/11/23.
 */
class HomeFragment : Fragment(),LiveView {
    override fun getLive(liveTab: LiveTab.DataBean) {
        liveTab.data.forEach {
            tablay.addTab(tablay.newTab().setText(it.game_name))
        }
        pager.adapter=MyAdapter(childFragmentManager,liveTab)
        tablay.setupWithViewPager(pager)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater?.inflate(R.layout.homefragment,container,false)
        ImmersionBar.with(activity).init();
        var tablay = inflate?.findViewById(R.id.tablay) as TabLayout
        val pager = inflate?.findViewById(R.id.pager) as ViewPager

        tablay.tabMode = TabLayout.MODE_SCROLLABLE



        return inflate
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val livePresenter = LivePresenter(this,activity)
        livePresenter.getLiveModel()
    }
     internal class MyAdapter(val fragmentManger : FragmentManager,var liveTab: LiveTab.DataBean) : FragmentPagerAdapter(fragmentManger){
         override fun getItem(position: Int): Fragment {
             return OneFragment.getInstance(liveTab.data!!.get(position)!!.short_name)
         }

         override fun getPageTitle(position: Int): CharSequence {
             return liveTab.data.get(position).game_name
         }
         override fun getCount(): Int {
             return liveTab.data.size
         }

     }

}