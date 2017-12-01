package com.bawei.superhero.utils

import android.content.Context
import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.provider.MediaStore
import com.bawei.superhero.bean.Song
import com.bawei.superhero.bean.VideoInfo

/**
 * 1. 音乐工具类
 * 2. @author chensi
 * 3. @date 2017/10/3 12:07
 */

object MusicUtils {
    //搜索音乐列表 返回song_id 根据song_id搜索播放地址
    val MUSIC_LIST = "http://route.showapi.com/213-1?showapi_appid= 47494&showapi_sign=94c8f5950ba64183abfaa31f1c4c0df7&page=1&keyword="
    //根据音乐id 搜索音乐
    val MUSIC_LYRIC = "http://route.showapi.com/213-2?showapi_appid= 47494&showapi_sign=94c8f5950ba64183abfaa31f1c4c0df7&musicid="
    //搜索视频
    val VEDIO_LIST = "http://route.showapi.com/255-1?showapi_appid=%2047494&showapi_sign=94c8f5950ba64183abfaa31f1c4c0df7&page=1&type=41"
    //Notification唯一标识
    val NOTI_CTRL_ID = 10000000


    //扫描本地音乐 返回list集合
    fun getMusicList(context: Context):MutableList<Song>? {
        val slist :MutableList<Song>?= ArrayList()
        // 媒体库查询语句
        val cursor = context.contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, MediaStore.Audio.AudioColumns.IS_MUSIC)
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val s = Song()
                s.song = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME))
                s.singer = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST))
                s.path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA))
                s.duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION))
                s.size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE))
                s.album_id = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID))
                s.isplay = false
                if (s.size > 1000 * 800) {
                    // 注释部分是切割标题，分离出歌曲名和歌手 （本地媒体库读取的歌曲信息不规范）
                    if (s.song.contains("-")) {
                        val str = s.song.split("-".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                        s.singer = str[0]
                        s.song = str[1]
                    }
                    slist?.add(s)
                }
            }
            // 释放资源
            cursor.close()
        }
        return slist
    }

    /**
     * 定义一个方法用来格式化获取到的时间
     */
    fun formatTime(time: Int): String {
        return if (time / 1000 % 60 < 10) {
            (time / 1000 / 60).toString() + ":0" + time / 1000 % 60

        } else {
            (time / 1000 / 60).toString() + ":" + time / 1000 % 60
        }

    }

    //根据album_id查找专辑图片
    fun getAlbumArt(album_id: String, context: Context): String? {
        val mUriAlbums = "content://media/external/audio/albums"
        val projection = arrayOf("album_art")
        var cur = context.contentResolver.query(
                Uri.parse(mUriAlbums + "/" + album_id),
                projection, null, null, null)
        var album_art: String? = null
        if (cur!!.count > 0 && cur.columnCount > 0) {
            cur.moveToNext()
            album_art = cur.getString(0)
        }
        cur.close()
        cur = null
        return album_art
    }

    //扫描本地视频
    fun getVideoList(context: Context): List<VideoInfo>? {
        var list: MutableList<VideoInfo>? = null
        val cursor = context.contentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null, null)
        if (cursor != null) {
            list = ArrayList()
            while (cursor.moveToNext()) {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID))
                val title = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.TITLE))  //视频文件的标题内容
                val album = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.ALBUM))
                val artist = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.ARTIST))
                val displayName = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME))
                val mimeType = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.MIME_TYPE))
                val path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA))  //
                val duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION)).toLong()
                val size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE))
                val videoinfo = VideoInfo(id, title, album, artist, displayName, mimeType, path, size, duration)
                list.add(videoinfo)
            }
            cursor.close()
        }
        return list
    }

    //获取视频缩略图
    fun getVideoThumbnail(filePath: String): Bitmap? {
        var bitmap: Bitmap? = null
        val retriever = MediaMetadataRetriever()
        try {
            retriever.setDataSource(filePath)
            bitmap = retriever.frameAtTime
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        } catch (e: RuntimeException) {
            e.printStackTrace()
        } finally {
            try {
                retriever.release()
            } catch (e: RuntimeException) {
                e.printStackTrace()
            }

        }
        return bitmap
    }
}
