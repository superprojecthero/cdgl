package com.bawei.superhero.utils

import android.content.Context
import android.util.Log
import com.bawei.superhero.inter.RetrofitService
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.internal.cache.CacheInterceptor
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.*
import java.util.concurrent.TimeUnit



/**
 *  1. 类的用途
 * 2. @author chensi
 * 3. @date 2017/11/23 09:47
 */
class RetrofitUtils (context: Context){
    var httpCacheDirectory : File? = null
    val mContext : Context = context
    var cache : Cache? = null
    var okHttpClient : OkHttpClient? = null
    var retrofit : Retrofit? = null
    val DEFAULT_TIMEOUT : Long = 20
    init {
        //缓存地址
        if (httpCacheDirectory == null) {
            httpCacheDirectory = File(mContext.cacheDir, "app_cache")
        }
        try {
            if (cache == null) {
                cache = Cache(httpCacheDirectory, 10 * 1024 * 1024)
            }
        } catch (e: Exception) {
            Log.e("OKHttp", "Could not create http cache", e)
        }
        val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            fun log(message: String) {
                Log.i("xxx", message.toString())
            }
        })
        //Okhttp3的拦截器日志分类 4种
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        //okhttp创建了
        okHttpClient = OkHttpClient.Builder()
                //添加OkHttp3的拦截器
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache)
                .writeTimeout(20, TimeUnit.SECONDS).readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build()

    }
    companion object {
        @Volatile
        var retrofit :RetrofitUtils?=null

        fun getInstance(context: Context) :RetrofitUtils?{
           if(retrofit==null){
               synchronized(RetrofitUtils::class.java){
                   if(retrofit==null){
                       retrofit= RetrofitUtils(context)
                   }
               }
           }
            return retrofit
        }
    }
    fun <T> create(service: Class<T>?,baseUrl: String): T? {
        //retrofit创建了
        retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build()
        if (service == null) {
            throw RuntimeException("Api service is null!")
        }
        return retrofit?.create(service)
    }

}