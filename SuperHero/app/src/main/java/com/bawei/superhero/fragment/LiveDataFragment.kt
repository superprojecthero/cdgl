package com.bawei.superhero.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bawei.superhero.R
import com.bawei.superhero.activity.LiveActivity
import com.bawei.superhero.mvp.presenter.LivePresenter
import com.bawei.superhero.mvp.view.LiveData
import com.bawei.superhero.utils.RoundTransform
import com.squareup.picasso.Picasso

/**
 *  1. 类的用途
 * 2. @author chensi
 * 3. @date 2017/11/28 08:50
 */
class LiveDataFragment : Fragment() ,LiveData{
    var srl : SwipeRefreshLayout?=null
    var rlv : RecyclerView?=null
    override fun getLiveData(liveData: com.bawei.superhero.bean.LiveData.DataBean) {
        val adapter = MyRecyclerView(activity, liveData)
        rlv?.adapter=adapter
        adapter.setClick(object :MyRecyclerView.OnClick{
            override fun SetOnClick(position: Int, liveData: com.bawei.superhero.bean.LiveData.DataBean) {
                val intent = Intent(activity, LiveActivity::class.java)
                intent.putExtra("url",liveData.data.get(position).url)
                startActivity(intent)
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater?.inflate(R.layout.livedatafragment, container, false)
        srl=inflate?.findViewById(R.id.srl) as SwipeRefreshLayout
        rlv=inflate?.findViewById(R.id.rlv) as RecyclerView
        rlv?.layoutManager=GridLayoutManager(activity,2)
        return inflate
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val string = arguments.getString("game")
        val livePresenter = LivePresenter(this, activity)
        if(string!=null&&!"".equals(string)){
           livePresenter.getLiveDataModel(string)
        }
    }
    companion object {
        fun newInstance(string: String):LiveDataFragment{
            var liveDataFragment = LiveDataFragment()
            var bundle = Bundle()
            bundle.putString("game",string)
            liveDataFragment.arguments=bundle
            return liveDataFragment
        }
    }
    internal class MyRecyclerView(var context: Context,var liveData: com.bawei.superhero.bean.LiveData.DataBean) : RecyclerView.Adapter<MyRecyclerView.MyHolder>() {

        override fun onBindViewHolder(holder: MyHolder?, position: Int) {
           Picasso.with(context).load(liveData.data.get(position).room_src).transform(RoundTransform(30)).into(holder?.image)
           holder?.name?.setText(liveData.data.get(position).room_name)
            holder?.itemView?.setOnClickListener{
                onClick?.SetOnClick(position,liveData)
            }
        }
        var onClick :OnClick?=null
        fun setClick(onClick: OnClick){
            this.onClick=onClick
        }
        interface OnClick{
            fun SetOnClick(position: Int,liveData: com.bawei.superhero.bean.LiveData.DataBean)
        }
        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
            var view:View?=null
            view=LayoutInflater.from(context).inflate(R.layout.livedata_view,parent,false)
            var holder=MyHolder(view)
            return holder
        }

        override fun getItemCount(): Int {
            return liveData.data.size
        }

        internal class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
            var image :ImageView?=itemView?.findViewById(R.id.image) as ImageView
            var name :TextView?=itemView?.findViewById(R.id.name) as TextView
        }
    }

}