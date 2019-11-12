package com.example.ktdemo

import android.app.Application
import android.content.Context
import com.danikula.videocache.HttpProxyCacheServer
import com.example.ktdemo.weight.MyFileNameGenerator

class App : Application() {

    val proxy: HttpProxyCacheServer? = null

    override fun onCreate() {
        super.onCreate()
    }

    companion object {

        fun getProxy(context: Context): HttpProxyCacheServer {
            val app: App = context.applicationContext as App
            return app.proxy ?: newProxy(context)
        }

        private fun newProxy(context: Context): HttpProxyCacheServer {
            return HttpProxyCacheServer.Builder(context)
                    .fileNameGenerator(MyFileNameGenerator())
//                .cacheDirectory()//缓存路径
                    .maxCacheFilesCount(100)//最大缓存文件数量
                    .maxCacheSize(500 * 1024 * 1024)//最大缓存大小
                    .build()
        }

    }


}