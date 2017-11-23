package com.bawei.superhero.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.bawei.superhero.R
import com.bawei.superhero.fragment.HomeFragment
import com.bawei.superhero.fragment.LiveFragment
import com.bawei.superhero.fragment.MusicFragment
import com.bawei.superhero.fragment.VideoFragment
import kotlinx.android.synthetic.main.activity_main.*
//梁彤
class MainActivity : AppCompatActivity(), BottomNavigationBar.OnTabSelectedListener {
   //初始化viewpager中的fragment
    var fraglist :Array<Fragment> = arrayOf(HomeFragment(),LiveFragment(),VideoFragment(),MusicFragment())

    //记录上一次的fragment
    var item :Int =0

    override fun onTabReselected(position: Int) {
    }

    override fun onTabUnselected(position: Int) {
    }

    override fun onTabSelected(position: Int) {
        swichtItem(position)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //初始化页面
        initData()
        //初始化控件
        initView()
    }

    private fun initData() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.vp,fraglist.get(0)).commit()
    }

    private fun initView() {
       //初始化底部导航栏
       bnb.setTabSelectedListener(this)
        //设置底部导航栏的模式
        bnb.setMode(BottomNavigationBar.MODE_FIXED)

        bnb.addItem(BottomNavigationItem(R.mipmap.home_pressed, "首页")).setActiveColor(R.color.itemselect)
        .addItem(BottomNavigationItem(R.mipmap.live_pressed, "直播")).setActiveColor(R.color.itemselect)
        .addItem(BottomNavigationItem(R.mipmap.follow_pressed, "视频")).setActiveColor(R.color.itemselect)
        .addItem(BottomNavigationItem(R.mipmap.user_pressed, "音乐")).setActiveColor(R.color.itemselect)
        .setFirstSelectedPosition(0)
                .initialise()
    }

    private fun swichtItem(position: Int) {
        val beginTransaction = supportFragmentManager.beginTransaction()
        if (position!=item){
            beginTransaction.hide(fraglist.get(item))
            if(!fraglist.get(position).isAdded){
                beginTransaction.add(R.id.vp,fraglist.get(position))
            }
            beginTransaction.show(fraglist.get(position)).commit()
            item=position
        }
    }


}
