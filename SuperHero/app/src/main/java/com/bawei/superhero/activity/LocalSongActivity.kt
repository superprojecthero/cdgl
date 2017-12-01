package com.bawei.superhero.activity

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bawei.superhero.R
import com.bawei.superhero.bean.Song
import com.bawei.superhero.fragment.MusicFragment.Companion.mBinder
import com.bawei.superhero.utils.MusicUtils
import com.squareup.picasso.Picasso


class LocalSongActivity : AppCompatActivity() {

    private var user: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local_song)

        var back = findViewById(R.id.back_ls) as ImageView
        var song_lv = findViewById(R.id.song_lv) as ListView
        var song_show = findViewById(R.id.song_show) as LinearLayout
        var song_message = findViewById(R.id.song_message) as ViewPager
        var song_pause1 = findViewById(R.id.song_pause) as CheckBox

        user = getSharedPreferences("user", Context.MODE_PRIVATE)

        //开始查询本地音乐
        val musicList = MusicUtils.getMusicList(this) as MutableList<Song>
        song_lv.adapter=MyListAdapter(musicList,this)

        //点击条目跳转
        song_lv.setOnItemClickListener { parent, view, position, id ->
            mBinder?.musicplay(musicList?.get(position)?.path)
        }

        back.setOnClickListener(View.OnClickListener {
            finish()
        })


    }



    //listview的适配器
    internal class MyListAdapter(var list:MutableList<Song>?,var context: Context) : BaseAdapter() {
      override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
          var viewholder=ViewHolder()
          var inflate:View
          if(convertView==null){
              inflate = LayoutInflater.from(context).inflate(R.layout.song_rl, parent, false)
              viewholder.song_graic= inflate.findViewById(R.id.song_graic) as TextView?
              viewholder.song_image= inflate.findViewById(R.id.song_image) as ImageView?
              viewholder.song_name= inflate.findViewById(R.id.song_name) as TextView?
              inflate.tag=viewholder
          }else{
              inflate=convertView
              viewholder= inflate.tag as ViewHolder
          }
          viewholder.song_graic?.setText(list?.get(position)?.song)
          viewholder.song_name?.text=list?.get(position)?.singer
          var albumArt = MusicUtils.getAlbumArt(list?.get(position)?.album_id, context)

          if(albumArt == null){
              viewholder.song_image?.setImageResource(R.mipmap.a8z)
          }else{
              Picasso.with(context).load(albumArt).into(viewholder.song_image)
          }
         return inflate
      }

      override fun getItem(position: Int): Any {
          return list!!.get(position)
      }

      override fun getItemId(position: Int): Long {
          var p:Long = position.toLong()
          return p
      }

      override fun getCount(): Int {
          return list!!.size
      }
      internal class ViewHolder{
          var song_image:ImageView?=null
          var song_name:TextView?=null
          var song_graic:TextView?=null
      }
  }

  /*  override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("position", p)
            intent.putExtra("isplay", song_pause1!!.isChecked())
            setResult(350, intent)
            finish()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }*/
}
