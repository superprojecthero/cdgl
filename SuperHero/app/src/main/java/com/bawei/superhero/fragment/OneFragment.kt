package com.bawei.superhero.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bawei.superhero.R
import com.bawei.superhero.activity.BannerImageLoader
import com.bawei.superhero.activity.MyImageLoader
import com.bawei.superhero.bean.HomeBean
import com.bawei.superhero.mvp.presenter.HomePresenterImpl
import com.bawei.superhero.mvp.view.HomeView
import com.bawei.superhero.utils.RoundTransform
import com.squareup.picasso.Picasso
import com.youth.banner.Banner

/**
 * Created by Administrator on 2017/11/25 0025.
 */

class OneFragment: Fragment(),HomeView {

    var srl : SwipeRefreshLayout?=null
    var rlv : RecyclerView?=null
    var list=ArrayList<HomeBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean>()
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater?.inflate(R.layout.onefragment, container, false)
        banner = inflate?.findViewById(R.id.banner) as Banner
        srl=inflate?.findViewById(R.id.swip) as SwipeRefreshLayout
        rlv=inflate?.findViewById(R.id.recy) as RecyclerView
        rlv?.layoutManager = GridLayoutManager(activity,2) as RecyclerView.LayoutManager?

        return inflate
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getBanner()
        var homePresenter= HomePresenterImpl(this)
        homePresenter.getHomeBean(activity)
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

    override fun setHome(homeBean : HomeBean) {
        Log.e("sss",homeBean.toString())
        for (i in homeBean.showapi_res_body!!.pagebean!!.contentlist!!.indices){
            var contentlistBean = homeBean.showapi_res_body!!.pagebean!!.contentlist!![i]
            list.add(contentlistBean)
        }
        var homeAdapter=MyHomeRecyclerView(activity,list)
       rlv?.adapter=homeAdapter
    }

    internal class MyHomeRecyclerView(mContext: Context,mVideo: List<HomeBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean>): RecyclerView.Adapter<MyHomeRecyclerView.MyViewHolder>() {
        private var context:Context=mContext
        private var video:List<HomeBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean> =mVideo

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            Picasso.with(context).load(video.get(position).profile_image).transform(RoundTransform(30)).into(holder?.home_img)
            holder?.home_title?.setText(video.get(position).text)

        }
        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder{

           var view=LayoutInflater.from(context).inflate(R.layout.home_video,parent,false)
            var holder=MyViewHolder(view)
            return holder
        }
        override fun getItemCount(): Int {
            return video.size
        }
        internal class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
            var home_img : ImageView?=itemView?.findViewById(R.id.home_img) as ImageView
            var home_title : TextView?=itemView?.findViewById(R.id.home_title) as TextView

        }

    }

}
