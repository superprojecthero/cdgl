package com.bawei.superhero.utils

import com.bawei.superhero.inter.RetrofitService
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

/**
 *  1. 类的用途
 * 2. @author chensi
 * 3. @date 2017/11/23 09:47
 */
class RetrofitUtils {

    companion object {
        var retrofit :Retrofit?=null

        fun getInstance(baseurl: String) :Retrofit?{
           if(retrofit==null){
               synchronized(RetrofitUtils::class.java){
                   if(retrofit==null){
                       retrofit = Retrofit.Builder()
                               .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                               .addConverterFactory(GsonConverterFactory.create())
                               .baseUrl(baseurl)
                               .build()
                   }
               }
           }
            return retrofit
        }
    }

}