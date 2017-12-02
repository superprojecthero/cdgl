package com.bawei.superhero.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

import com.bawei.superhero.R
import com.bawei.superhero.bean.Song

/**
 * 1. 类的用途
 * 2. @author chensi
 * 3. @date 2017/10/5 17:13
 */

class FindAdapter(private val context: Context, private val songs: List<Song>) : BaseAdapter() {

    override fun getCount(): Int {
        return songs.size
    }

    override fun getItem(position: Int): Any {
        return songs[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val holder: ViewHolder
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.find_lv, null)
            holder = ViewHolder()
            holder.song_name = convertView!!.findViewById(R.id.song_name) as TextView
            holder.song_singer = convertView.findViewById(R.id.song_singer) as TextView
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        holder.song_name!!.text = songs[position].song
        holder.song_singer!!.text = songs[position].singer + "--" + songs[position].album

        return convertView
    }

    internal inner class ViewHolder {
        var song_name: TextView? = null
        var song_singer: TextView? = null
    }
}
