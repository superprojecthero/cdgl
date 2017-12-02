package com.bawei.superhero.bean

/**
 * Created by Administrator on 2017/12/1 0001.
 */

class HomeBean {


    var showapi_res_code: Int = 0
    var showapi_res_error: String? = null
    var showapi_res_body: ShowapiResBodyBean? = null


    class ShowapiResBodyBean {


        var ret_code: Int = 0
        var pagebean: PagebeanBean? = null

        class PagebeanBean {
            var allPages: Int = 0
            var currentPage: Int = 0
            var allNum: Int = 0
            var maxResult: Int = 0
            var contentlist: List<ContentlistBean>? = null
            class ContentlistBean {

                var text: String? = null
                var hate: String? = null
                var videotime: String? = null
                var voicetime: String? = null
                var weixin_url: String? = null
                var profile_image: String? = null
                var width: String? = null
                var voiceuri: String? = null
                var type: String? = null
                var ct: String? = null
                var id: String? = null
                var love: String? = null
                var height: String? = null
                var _id: String? = null
                var video_uri: String? = null
                var voicelength: String? = null
                var name: String? = null
                var create_time: String? = null
                override fun toString(): String {
                    return "ContentlistBean(text=$text, hate=$hate, videotime=$videotime, voicetime=$voicetime, weixin_url=$weixin_url, profile_image=$profile_image, width=$width, voiceuri=$voiceuri, type=$type, ct=$ct, id=$id, love=$love, height=$height, _id=$_id, video_uri=$video_uri, voicelength=$voicelength, name=$name, create_time=$create_time)"
                }

            }

            override fun toString(): String {
                return "PagebeanBean(allPages=$allPages, currentPage=$currentPage, allNum=$allNum, maxResult=$maxResult, contentlist=$contentlist)"
            }
        }
        override fun toString(): String {
            return "ShowapiResBodyBean(ret_code=$ret_code, pagebean=$pagebean)"
        }
    }
    override fun toString(): String {
        return "HomeBean(showapi_res_code=$showapi_res_code, showapi_res_error=$showapi_res_error, showapi_res_body=$showapi_res_body)"
    }
}
