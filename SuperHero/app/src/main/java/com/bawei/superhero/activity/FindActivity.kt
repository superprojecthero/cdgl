package com.bawei.superhero.activity

import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bawei.superhero.R
import com.bawei.superhero.bean.HttpSong
import com.bawei.superhero.bean.Song
import com.bawei.superhero.inter.RetrofitService
import com.bawei.superhero.utils.RetrofitUtils
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_find.*
import java.io.Serializable
import java.util.*

class FindActivity : AppCompatActivity() {

    private var slist: List<Song>? = null
    private var query_text: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find)

        var back = findViewById(R.id.back_find) as ImageView
        var edit_query = findViewById(R.id.edit_query) as EditText
        var find_lv = findViewById(R.id.find_lv) as ListView

        slist = ArrayList()


        back.setOnClickListener(View.OnClickListener {
            finish()
        })
        //搜索按钮
        val view = View.inflate(this, R.layout.pop_query, null)
        query_text = view.findViewById(R.id.query_text) as TextView
        val popupWindow = PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        popupWindow.isFocusable = true
        popupWindow.setBackgroundDrawable(ColorDrawable())

        //实时监听输入框的变化
        edit_query.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null && "" != s) {
                    edit_query.setOnClickListener { v ->
                        if (popupWindow.isShowing) {
                            popupWindow.dismiss()
                        } else {
                            popupWindow.showAsDropDown(v, 0, 0)
                            query_text!!.setText("搜索“$s”")
                            //请求网络
                            query_text!!.setOnClickListener(View.OnClickListener {
                                popupWindow.dismiss()
                                getMusicList(s.toString())
                            })
                        }
                    }

                }
            }

            override fun afterTextChanged(s: Editable) {

            }
        })

    }

    private fun getMusicList(string: String) {
        var instance = RetrofitUtils.getInstance(this)
        val retrofitService = instance?.create(RetrofitService::class.java, "http://route.showapi.com/")
        val flowable = retrofitService?.getMusic(string)
        flowable?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { song: HttpSong ->
                    val contentlist = song.showapi_res_body?.pagebean?.contentlist as MutableList<HttpSong.ShowapiResBodyBean.PagebeanBean.ContentlistBean>
                    find_lv.adapter=MyListAdapter(contentlist,this)
                }
    }



    //接受数据
    internal var handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.what == 0) {
                val s = msg.obj.toString()
                val gson = Gson()
                val hs = gson.fromJson(s, HttpSong::class.java)
                val showapi_res_body = hs.showapi_res_body
                val pagebean = showapi_res_body!!.pagebean
                val contentlist = pagebean!!.contentlist
                if (contentlist != null && contentlist!!.size > 0) {
                    for (i in contentlist!!.indices) {
                        val song = Song()
                        song.isplay = false
                        song.album = contentlist!!.get(i).albumname!!
                        song.album_id = contentlist!!.get(i).albumpic_big!!
                        song.path = contentlist!!.get(i).m4a!!
                        song.singer = contentlist!!.get(i).singername!!
                        song.song = contentlist!!.get(i).songname!!
                        song.duration = contentlist!!.get(i).songid//网络音乐的id
                        song.downUrl = contentlist!!.get(i).downUrl!!
                        //slist.add(song)
                    }
                    //点击事件
                    find_lv.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                        val intent = Intent(this@FindActivity, DetailActivity2::class.java)
                        intent.putExtra("songs", slist as Serializable)
                        //传过去一个标识 分别到底是本地音乐还是网络音乐
                        intent.putExtra("isHttp", false)
                        intent.putExtra("posotion", position)
                        startActivity(intent)
                    }
                }


            }
        }
    }
    //listview的适配器
    internal class MyListAdapter(var list:MutableList<HttpSong.ShowapiResBodyBean.PagebeanBean.ContentlistBean>,var context: Context) : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var viewholder=ViewHolder()
            var inflate:View
            if(convertView==null){
                inflate = LayoutInflater.from(context).inflate(R.layout.song_rl, parent, false)
                viewholder.song_singer= inflate.findViewById(R.id.song_graic) as TextView?
                viewholder.song_name= inflate.findViewById(R.id.song_name) as TextView?
                inflate.tag=viewholder
            }else{
                inflate=convertView
                viewholder= inflate.tag as ViewHolder
            }
            Log.e("SSSS",list.get(position)?.songname)
            viewholder.song_singer?.setText(list.get(position)?.songname)
            viewholder.song_name?.text=list.get(position)?.singername

            return inflate
        }

        override fun getItem(position: Int): HttpSong.ShowapiResBodyBean.PagebeanBean.ContentlistBean? {
            return list.get(position)
        }

        override fun getItemId(position: Int): Long {
            var p:Long = position.toLong()
            return p
        }

        override fun getCount(): Int {
            return list.size
        }
        internal class ViewHolder{
            var song_name:TextView?=null
            var song_singer:TextView?=null
        }
    }
}
