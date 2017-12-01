package com.bawei.superhero.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bawei.superhero.R;
import com.bawei.superhero.bean.Song;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author chensi
 * 3. @date 2017/10/5 17:13
 */

public class FindAdapter extends BaseAdapter{
    private Context context;
   private List<Song> songs;

    public FindAdapter(Context context, List<Song> songs) {
        this.context = context;
        this.songs = songs;
    }

    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Object getItem(int position) {
        return songs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView=View.inflate(context, R.layout.find_lv,null);
            holder=new ViewHolder();
            holder.song_name=(TextView)convertView.findViewById(R.id.song_name);
            holder.song_singer=(TextView)convertView.findViewById(R.id.song_singer);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();
        }
        holder.song_name.setText(songs.get(position).getSong());
        holder.song_singer.setText(songs.get(position).getSinger()+"--"+songs.get(position).getAlbum());

        return convertView;
    }
    class ViewHolder{
        TextView song_name;
        TextView song_singer;
    }
}
