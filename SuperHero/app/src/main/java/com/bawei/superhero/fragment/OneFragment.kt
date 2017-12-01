package com.bawei.superhero.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bawei.superhero.R
import com.bawei.superhero.activity.BannerImageLoader
import com.bawei.superhero.activity.MyImageLoader
import com.youth.banner.Banner

/**
 * Created by Administrator on 2017/11/25 0025.
 */

class OneFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater?.inflate(R.layout.onefragment, container, false)
        banner = inflate?.findViewById(R.id.banner) as Banner
        return inflate
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getBanner()
    }
 companion object {
     fun getInstance(name:String):OneFragment{
         var fragment : OneFragment =OneFragment()
         return fragment
     }
 }
    internal var banner: Banner? = null
    private fun getBanner() {
        banner!!.setImageLoader(MyImageLoader())
        val list = ArrayList<String>()
        val img1 = "http://pic35.photophoto.cn/20150528/0005018358146030_b.jpg"
        val img2 = "http://pic8.nipic.com/20100801/387600_002750589396_2.jpg"
        val img3 = "http://img0.imgtn.bdimg.com/it/u=1783000275,3379371754&fm=214&gp=0.jpg"
        val img4 = "http://f8.topitme.com/8/59/88/1135063381d7088598o.jpg"
        val img5 = "http://pic33.photophoto.cn/20141103/0005018358711181_b.jpg"
        val img6 = "http://pic33.photophoto.cn/20141029/0005018400189939_b.jpg"

        list.add(img1)
        list.add(img2)
        list.add(img3)
        list.add(img4)
        list.add(img5)
        list.add(img6)
        banner!!.setImageLoader(BannerImageLoader())
        banner!!.setImages(list)
        banner!!.start()
    }


}
