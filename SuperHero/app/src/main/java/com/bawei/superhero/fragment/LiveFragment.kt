package com.bawei.superhero.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bawei.superhero.LiveTab
import com.bawei.superhero.R
import com.bawei.superhero.mvp.presenter.LivePresenter
import com.bawei.superhero.mvp.view.LiveView
import com.gyf.barlibrary.ImmersionBar
import kotlinx.android.synthetic.main.livefragment.*

/**
 * Created by la on 2017/11/23.
 */
class LiveFragment : Fragment(),LiveView{
    override fun getLive(liveTab: LiveTab.DataBean) {
       liveTab.data.forEach {
           tab.addTab(tab.newTab().setText(it.cate_name))
       }

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater?.inflate(R.layout.livefragment, container, false)
        ImmersionBar.with(activity).init();
        val tab = inflate?.findViewById(R.id.tab) as TabLayout
        tab.tabMode=TabLayout.MODE_SCROLLABLE
        return inflate
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val livePresenter = LivePresenter(this,activity)
        livePresenter.getLiveModel()
    }
}