package com.bawei.superhero.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

import com.bawei.superhero.R
import com.bawei.superhero.bean.Song

/**
 * 1. 类的用途
 * 2. @author chensi
 * 3. @date 2017/10/3 13:35
 */

class SongAdapter(private val slist: List<Song>, private val context: Context) : BaseAdapter() {

    override fun getCount(): Int {
        return slist.size
    }

    override fun getItem(position: Int): Any {
        return slist[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val holder: ViewHolder
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.lv_view, null)
            holder = ViewHolder()
            holder.song_name = convertView!!.findViewById(R.id.song_name) as TextView
            holder.song_singer = convertView.findViewById(R.id.song_singer) as TextView
            holder.song_state_image = convertView.findViewById(R.id.song_state_image) as ImageView
            holder.song_play = convertView.findViewById(R.id.song_play) as ImageView
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        holder.song_name!!.text = slist[position].song
        holder.song_singer!!.text = slist[position].singer
        if (slist[position].singer == "<unknown>") {
            holder.song_state_image!!.setImageResource(R.mipmap.zj)
        } else {
            holder.song_state_image!!.setImageResource(R.mipmap.zb)
        }
        if (slist[position].isplay!!) {
            holder.song_play!!.visibility = View.VISIBLE
        } else {
            holder.song_play!!.visibility = View.GONE
        }
        return convertView
    }

    internal inner class ViewHolder {
        var song_name: TextView? = null
        var song_singer: TextView? = null
        var song_play: ImageView? = null
        var song_state_image: ImageView? = null
    }
}
